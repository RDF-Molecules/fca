import breeze.linalg.{DenseMatrix, DenseVector}

object Main extends App {

  //Example from Paper
  /*val minteFca = new MinteFca(DenseMatrix(
    (0, 1, 1, 0, 1, 1, 0, 1),
    (1, 0, 0, 1, 0, 0, 1, 1),
    (1, 1, 1, 1, 0, 1, 1, 0),
    (0, 1, 0, 0, 1, 1, 0, 0),
    (1, 1, 0, 0, 1, 1, 1, 1))) */

  //Example from Wikipedia
  val minteFca = new MinteFca(DenseMatrix(
    (0, 1, 0, 0, 1, 0),
    (0, 1, 0, 0, 1, 0),
    (0, 0, 1, 1, 1, 1),
    (0, 0, 1, 1, 1, 0),
    (0, 0, 1, 1, 1, 0),
    (1, 0, 1, 1, 0, 0),
    (0, 0, 1, 1, 1, 0),
    (0, 0, 1, 1, 1, 0),
    (0, 0, 0, 1, 1, 0),
    (0, 1, 1, 0, 1, 0),
    (0, 1, 1, 0, 1, 0),
    (0, 1, 1, 0, 1, 0),
    (0, 0, 1, 1, 1, 1),
    (0, 1, 1, 0, 1, 0),
    (0, 0, 1, 1, 1, 0),
    (0, 1, 1, 0, 1, 0),
    (0, 1, 1, 0, 1, 0)))

  //val emptyD = DenseVector()

  //minteFca.print()

  //val d = minteFca.compute_closure(DenseVector(0,0,0,0,1,1,0,0), 7)
  //println(s"D: $d")

  //println(s"X: ${minteFca.X} Y: ${minteFca.Y}")

  val intents = minteFca.generate_from(DenseVector(0,0,0,0,0,0,0,0), 0)

  //val A = minteFca.compute_galois(DenseVector(0,1,2,3,4,5,6,7))
  //println(s"A: $A")

}