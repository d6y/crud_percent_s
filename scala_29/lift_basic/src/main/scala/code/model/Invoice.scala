package code
package model

import net.liftweb._
import mapper._
import util._
import common._

object Invoice extends Invoice with KeyedMetaMapper[Long, Invoice] with CRUDify[Long, Invoice] {
  override def dbTableName = "invoice"
}

class Invoice extends KeyedMapper[Long, Invoice] {
  def getSingleton = Invoice
  def primaryKeyField = id

  object id extends MappedLongIndex(this)

  object userId extends MappedLongForeignKey(this, User) {
    override def validSelectValues = Full(User.findAll.map(x => (x.id.is, x.niceName)))
  }


  object value extends MappedLong(this)
}

