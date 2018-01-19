import breeze.linalg.{DenseMatrix, DenseVector}

object Main extends App {

  val minteFca = new MinteFca(DenseMatrix(
    (0, 1, 1, 0, 1, 1, 0, 1),
    (1, 0, 0, 1, 0, 0, 1, 1),
    (1, 1, 1, 1, 0, 1, 1, 0),
    (0, 1, 0, 0, 1, 1, 0, 0),
    (1, 1, 0, 0, 1, 1, 1, 1)))

  //minteFca.print()
  val d = minteFca.compute_closure(DenseVector(4,5), 7)
  println(s"D: $d")

}

/*
  val ctx = DenseMatrix((0, 1, 1, 0, 1, 1, 0, 1),
                        (1, 0, 0, 1, 0, 0, 1, 1),
                        (1, 1, 1, 1, 0, 1, 1, 0),
                        (0, 1, 0, 0, 1, 1, 0, 0),
                        (1, 1, 0, 0, 1, 1, 1, 1))

  val n = ctx.cols

  println(ctx)

  //Getting all columns
  //val rows = ctx(::,0)
  //println(rows)

  //val rows = ctx(::, ( 0 to (ctx.cols - 1) )).toArray.zipWithIndex.filter(_._1 == 1)
  val oneRow = ctx(::, 0).toArray.zipWithIndex.filter(_._1 == 1).map(_._2)
  println(oneRow.size) //Should be 3

  //val rows = ctx(::, ( 0 to (ctx.cols - 1) )).toArray.zipWithIndex.filter(_._1 == 1)
  val rows = for (i <- Range(0, ctx.cols))
                yield ctx(::, i).toArray
                    .zipWithIndex
                    .filter(_._1 == 1).map(_._2)
  println(rows.size)

  compute_closure(DenseVector(4,5), 7, n)

  def compute_closure(B : DenseVector[Int], y: Int, n: Int) = {
    /*
    * 1. for j from 0 upto n do
    * 2.  set D[j] to 1;
    * 3. end
    */
    val D = DenseVector.ones[Int](n)

    println("Computing Closure")
  }
  */