package controllers

import breeze.linalg.DenseMatrix
import javax.inject._
import play.Logger
import play.api.mvc._
import services.FCAService

/**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class FCAController @Inject()(cc: ControllerComponents) (implicit assetsFinder: AssetsFinder)
  extends AbstractController(cc) {

  /**
    * Create an Action to render an HTML page with a welcome message.
    * The configuration in the `routes` file means that this method
    * will be called when the application receives a `GET` request with
    * a path of `/`.
    */
  def applyFCA = Action(parse.json) { request =>
    val data = (request.body \ "data").as[Array[Array[Int]]]
    val fca = new FCAService(DenseMatrix(
      data(0),
      data(1)))
    val results = fca.computeFca()
    Ok(fca.printFca(results).toString)
  }

  def applyFCAtoMolecules = Action(parse.json) { request =>
    val data = (request.body \ "data").as[Array[Array[Int]]]
    val fca = new FCAService(DenseMatrix(
      data(0),
      data(1)))
    val results = fca.computeFca()
    Ok(fca.printFca(results).toString)
  }

}
