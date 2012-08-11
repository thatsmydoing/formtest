package models

import play.api.data._
import play.api.data.Forms._

object Student {
	val form = Form(mapping(
		"name" -> nonEmptyText,
		"age" -> number,
		"school" -> nonEmptyText,
		"grade" -> number
	)(Student.apply)(Student.unapply))
}

case class Student (
	name: String,
	age: Int,
	school: String,
	grade: Int
) extends Person
