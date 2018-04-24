/**
 * @author Adston Oliveira LinhaVerde Informatica
 */
public class Element {

   private String valueElement;
   
   Element next;
   Element previous = null;
   
   public Element( String valueElement ){
      this.valueElement = valueElement;
   }
   
   public String getValue(){
      return this.valueElement;
   }



   
}
