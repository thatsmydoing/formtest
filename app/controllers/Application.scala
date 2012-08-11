package controllers

import play.api._
import play.api.mvc._
import models._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def employee = Action { implicit request =>
	Ok(views.html.employeeForm(Employee.form.bindFromRequest))
  }

  def student = Action { implicit request =>
	Ok(views.html.studentForm(Student.form.bindFromRequest))
  }

}
