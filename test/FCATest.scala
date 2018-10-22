import breeze.linalg.{DenseMatrix, DenseVector}
import services.FCAService

object FCATest extends App {

  //Example from Paper
  /*val minteFca = new MinteFca(DenseMatrix(
    (0, 1, 1, 0, 1, 1, 0, 1),
    (1, 0, 0, 1, 0, 0, 1, 1),
    (1, 1, 1, 1, 0, 1, 1, 0),
    (0, 1, 0, 0, 1, 1, 0, 0),
    (1, 1, 0, 0, 1, 1, 1, 1))) */

  //Example from Wikipedia
  /*val minteFca = new MinteFca(DenseMatrix(
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
  */

  //Paper sameAs
  /*
                              0                     1                 2                   3                     4
                    tbox:prod->abox:binc  tbox:prod->abox:cinc  owl:sameAs->X  tbox:chem->abox:aspirin  rdf:type->Drug
    0 abox:baspirin           1                     0                 1                   1                     1
    1 abox:caspirin           0                     1                 1                   1                     1
   */
  val minteFca = new FCAService(DenseMatrix(
    (1, 0, 1, 1, 1),
    (0, 1, 1, 1, 1)))

  //val emptyD = DenseVector()

  //minteFca.print()

  //val d = minteFca.compute_closure(DenseVector(0,0,0,0,1,1,0,0), 7)
  //println(s"D: $d")

  //println(s"X: ${minteFca.X} Y: ${minteFca.Y}")

  //val intents = minteFca.generate_from(DenseVector(0,0,0,0,0,0,0,0), 0)

  //val A = minteFca.compute_galois(DenseVector(1,2,3,4))
  //println(s"A: $A")

  val results = minteFca.computeFca()
  minteFca.printFca(results)

}