package views.html

import play.api.data._
import play.api.libs.json.JsValue

object FormView {
	implicit def formToFormView[A, T >: A](form: Form[A]): FormView[T] = new FormView[T] {
		type F = A
		def realForm = form
	}

	implicit def formViewToFormView[A, T >: A](form: FormView[A]): FormView[T] = formToFormView(form.realForm)
}

trait FormView[+T] {
	type F <: T

	def realForm: Form[F]

	def apply(key: String): Field = realForm(key)

	def constraints : Map[String, Seq[(String, Seq[Any])]] = realForm.constraints

	def data: Map[String, String] = realForm.data

	def error(key: String): Option[FormError] = realForm.error(key)

	def errors(key: String): Seq[FormError] = realForm.errors(key)

	def errors: Seq[FormError] = realForm.errors

	def errorsAsJson: JsValue = realForm.errorsAsJson

	def get: T = realForm.get

	def formats: Map[String, (String, Seq[Any])] = realForm.formats

	def globalError: Option[FormError] = realForm.globalError

	def globalErrors: Seq[FormError] = realForm.globalErrors

	def hasErrors: Boolean = realForm.hasErrors

	def hasGlobalErrors: Boolean = realForm.hasGlobalErrors

	override def hashCode: Int = realForm.hashCode

	def mapping: Mapping[F] = realForm.mapping

	def value: Option[T] = realForm.value
}
