package libraries

import com.mongodb.{DB, MongoClient}


/**
  * Created by denzyl on 11/18/15.
  */
object MongoDB {
  val mongoClient = new MongoClient()
  def getDB : DB = mongoClient.getDB("double")
}
