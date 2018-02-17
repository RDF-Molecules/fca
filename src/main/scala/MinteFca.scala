import breeze.linalg._
import util.control.Breaks._

class MinteFca(ctx: DenseMatrix[Int]){

  val rows = for (i <- Range(0, ctx.cols))
                yield ctx(::, i).toArray
                                .zipWithIndex
                                .filter(_._1 == 1).map(_._2)

  val n = ctx.cols
  val Y = DenseVector(0,1,2,3,4,5,6,7)
  val X = DenseVector(0,1,2,3,4)

  def print() = {
    println("Matrix: "+ctx)
    println("Rows Size: "+rows.size)
    println("n: "+n)
  }

  def compute_closure(B : DenseVector[Int], y: Int): DenseVector[Int] = {
    //println(s"Computing Closure with B: $B and y: $y")
    val iB = B//initInternalB(B)
    // 1. for j from 0 upto n do
    // 2.  set D[j] to 1;
    val D = DenseVector.ones[Int](n)
    //4. foreach i in rows[y] do
    rows(y).foreach { i =>
      //println(s"Starting to work D$i")
      //5. set match to true;
      var iMatch = true
      //6. for j from 0 upto n do
      for(j <- Range(0, n)) {
        breakable {
          //7. if B[j] = 1 and context[i, j] = 0 then
          //println(s"Validation context[$i,$j] = ${ctx(i, j)}")
          if (iB(j) == 1 && ctx(i, j) == 0) {
            //8. set match to false;
            //9. break for loop
            iMatch = false
            break
          }
        }
      }
      //12. if match = true then
      if (iMatch) {
        //println(s"We have a match for Object $i")
        //13. for j from 0 upto n do
        for(j <- Range(0, n)) {
          //14. if context[i, j] = 0 then
          if(ctx(i,j) == 0) {
            //15. set D[j] to 0;
            D(j) = 0
          }
        }
      }
    }
    D
    //val dIndexes = D.toArray
    //  .zipWithIndex
    //  .filter(_._1 == 1).map(_._2)
    //DenseVector(dIndexes)
  }

  private def initInternalB(B: DenseVector[Int] ) : DenseVector[Int] = {
    val iB = DenseVector.zeros[Int](n)
    B.map{ m => iB(m) = 1 }
    iB
  }

  def generate_from (B : DenseVector[Int], y: Int): Unit = {
    //1. process B (e.g., print B on screen);
    println(s"Intent B${y+1}: ${transformToIndexes(B)}")
    //2. if B = Y or y > n then
    //3.    return
    if (B == initInternalB(Y) || y > n ) {
      println("Returning due to condition: if B = Y or y > n ")
    }
    else {
      //5. for j from y upto n do
      for(j <- Range(y, n)) {
        //6. if B[j] = 0 then
        if (B(j) == 0) {
          //7. set B[j] to 1;
          B(j) = 1
          //8. set D to compute closure(B, j);
          val D = compute_closure(B, j)
          //9. set skip to false;
          var skip = false
          //10. for k from 0 upto j −1 do
          for(k <- Range(0, (j-1) )) {
            breakable {
              //11. if D[k] <> B[k] then
              if (D(k) != B(k)) {
                //12. set skip to true;
                skip = true
                //13. break for loop ;
                break
              }
            }
          }
          //16. if skip = false then
          if (!skip) {
            //17. generate_from(D, j +1);
            generate_from(D, j+1)
          }
          //19. set B[j] to 0 ;
          B(j) = 0
        }
      }
    }
  }

  def compute_galois(B : DenseVector[Int]) : DenseVector[Int] = {
    val A = DenseVector[Int]()
    val result = X.map{ x =>
      var insert = true
      B.foreach{ y =>
        breakable {
          if (ctx(x, y) == 0) {
            insert = false
            break
          }
        }
      }
      if (insert)
        x
      else
        None
    }.findAll( x1 => x1.isInstanceOf[Int]).toArray
    DenseVector(result)
  }

  private def transformToIndexes(d: DenseVector[Int]) : DenseVector[Int] = {
    val dIndexes = d.toArray
      .zipWithIndex
      .filter(_._1 == 1).map(_._2)
    DenseVector(dIndexes)
  }

}
