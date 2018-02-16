import breeze.linalg.{DenseMatrix, DenseVector}

object Main extends App {

  val minteFca = new MinteFca(DenseMatrix(
    (0, 1, 1, 0, 1, 1, 0, 1),
    (1, 0, 0, 1, 0, 0, 1, 1),
    (1, 1, 1, 1, 0, 1, 1, 0),
    (0, 1, 0, 0, 1, 1, 0, 0),
    (1, 1, 0, 0, 1, 1, 1, 1)))

  //val emptyD = DenseVector()

  //minteFca.print()

  //val d = minteFca.compute_closure(DenseVector(1,5), 8)
  //println(s"D: $d")

  val A = minteFca.compute_galois(DenseVector(7))
  println(s"A: $A")

  //val intents = minteFca.generate_from(DenseVector(0,1,5,6), 0)
}