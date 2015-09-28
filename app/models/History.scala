package models

/**
 * @author denzyl
 */
class History(user: User) {

      def get(start:Int,limit:Int): List[Any] =
      {
        /**
         * Get chat history
         */
        List(0,0)
      }
      
      def add(message:Message): Unit ={
		  /**
		   * Save message history
		   */
	  }
}
