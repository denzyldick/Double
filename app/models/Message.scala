package models

import com.mongodb.DBObject
import com.mongodb.casbah.commons.MongoDBObject
import libraries.MongoDB

/**
  * Every message should be persisted into the data-store
 * @author denzyl
 */
class Message(data:String) {
    def get : String = {
        data
    }

    def store(owner:User) : Unit = MongoDB.getDB.getCollection("chat_log").insert( )

}
