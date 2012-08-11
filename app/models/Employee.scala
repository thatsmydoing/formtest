package models

import play.api.data._
import play.api.data.Forms._

object Employee {
	val form = Form(mapping(
		"name" -> nonEmptyText,
		"age" -> number,
		"company" -> nonEmptyText,
		"position" -> nonEmptyText
	)(Employee.apply)(Employee.unapply))
}

case class Employee (
	name: String,
	age: Int,
	company: String,
	position: String
) extends Person
