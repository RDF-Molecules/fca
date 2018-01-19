import breeze.linalg._
import util.control.Breaks._

class MinteFca(ctx: DenseMatrix[Int]){

  val rows = for (i <- Range(0, ctx.cols))
                yield ctx(::, i).toArray
                                .zipWithIndex
                                .filter(_._1 == 1).map(_._2)


  val n = ctx.cols

  def print() = {
    println("Matrix: "+ctx)
    println("Rows Sice: "+rows.size)
    println("n: "+n)
  }

  def compute_closure(B : DenseVector[Int], y: Int): DenseVector[Int] = {
    println(s"Computing Closure with B: $B and y: $y")
    val iB = initInternalB(B)
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
        println(s"We have a match for Object $i")
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
  }

  private def initInternalB(B: DenseVector[Int] ) : DenseVector[Int] = {
    val iB = DenseVector.zeros[Int](n)
    B.map{ m => iB(m) = 1 }
    iB
  }

}
