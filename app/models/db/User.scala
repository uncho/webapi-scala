package models.db

import javax.inject.{Singleton, Inject}

import scala.concurrent.Future

import play.api.Play

import play.api.db.slick.DatabaseConfigProvider
import play.api.db.slick.HasDatabaseConfig
import slick.driver.JdbcProfile
import slick.driver.MySQLDriver.api._

/**
  * DTOの定義
  */
case class User(user_id: Int, name: Option[String])

/**
  *  テーブルスキーマの定義
  */
trait UserComponent {
	class UserTable(tag: Tag) extends Table[User](tag, "user_data") {
		def user_id = column[Int]("user_id", O.PrimaryKey)
		def name = column[Option[String]]("name")
		def * = (user_id, name) <> (User.tupled, User.unapply)
	}
}

/**
  * DAOの定義
  */
@Singleton
class UserDAO @Inject()(val dbConfigProvider: DatabaseConfigProvider)extends UserComponent with HasDatabaseConfig[JdbcProfile] {

	// DI
	protected lazy val dbConfig = dbConfigProvider.get[JdbcProfile]

	lazy val userQuery = TableQuery[UserTable]

	/**
	  * ID検索
	  *
	  * @param id
	  */
	def searchByID(id: Int): Future[Option[User]] = {
		dbConfig.db.run(userQuery.filter(_.user_id === id).result.headOption)
	}

	/**
	  * 全件検索(idの昇順)
	  */
	def searchAll: Future[Seq[User]] = {
		dbConfig.db.run(userQuery.sortBy(_.user_id.asc).result)
	}

	/**
	  * 全件検索(idの降順)
	  */
	def searchAllDesc: Future[Seq[User]] = {
		dbConfig.db.run(userQuery.sortBy(_.user_id.asc).result)
	}

	/**
	  * 作成
	  *
	  * @param user
	  */
	def create(user: User) {
		dbConfig.db.run(userQuery += user)
	}

	/**
	  * 更新
	  *
	  * @param user
	  */
	def update(user: User) {
		dbConfig.db.run(userQuery.filter(_.user_id === user.user_id).update(user))
	}

	/**
	  * 削除
	  *
	  * @param user
	  */
	def remove(user: User) {
		dbConfig.db.run(userQuery.filter(_.user_id === user.user_id).delete)
	}
}