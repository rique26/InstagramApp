package co.tiagoaguiar.course.instagram.common.model

data class UserAuth(
  val uuid: String,
  val name: String,
  val email: String,
  val password: String
)
