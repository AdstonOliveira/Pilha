
import javax.swing.JOptionPane;

/**
 *
 * @author Adston Oliveira LinhaVerde Informatica
 */
public class ListPile {
   
   public ListPile(){
      JOptionPane.showMessageDialog( null, "List Empty, insert values please");
   }
   
   
   
   Element first;
   Element top;
   String titleClear = "ADD ITENS IN LIST" ;
   String msgCleaning = "The list is Clear. :( \nInsert values Please";
   String msgLIFO = "In Pile, the Last In/add is the First Out !!!";
   String msgAdd = "Sucess To add: ";
   String msgRemoved = "Sucess, Element removed";
   
   public boolean isEmpty(){
      
      return first == null;
      
   }
   public Element getLast(){
      Element last = null;
         if( !isEmpty() ){
         last = this.first;
            while( last.next != null )
               last = last.next;
         }
         
        return last;
   }
   public boolean add( Element element ){
     
     if( isEmpty() ){
        this.first = element;
        this.top = this.first;
        JOptionPane.showMessageDialog( null, ( this.msgAdd+element.getValue() ) );
     return true;
     }else{
        Element temp = this.getLast();
        temp.next = element;
        this.top = element;
        JOptionPane.showMessageDialog( null, ( this.msgAdd+element.getValue() ) );
     return true;
     }
  }
   
   public boolean add(){
      String object = JOptionPane.showInputDialog( "Insert value in here:" );
         if( object == null ){
            JOptionPane.showMessageDialog( null,"Canceled by User" ,"Canceled", 2);
            return false;
         }
         
         Element element = new Element(object);
         
         
         return add(element);
      }
   public boolean showArray(){
      String reverse;
      do{
      reverse = JOptionPane.showInputDialog( "Choose: \n(1) to Normal View \n(2) to Reverse View" );
      
         if( reverse == null ){
            JOptionPane.showMessageDialog( null,"Canceled by User" ,"Canceled", 2);
            return false;
         }
      }while( !reverse.equalsIgnoreCase("1") && !reverse.equalsIgnoreCase("2") );
      
      JOptionPane.showMessageDialog( null, this.showArray( reverse, first) );
      return true;
   }
   private String showArray( String reverse, Element element ){
      String array = "";
      
      if( element.next != null ){
         if( reverse.equalsIgnoreCase( "1" ) )
            array +=( element.getValue()+ " | " + showArray( reverse, element.next ));
         else
            array +=( showArray( reverse, element.next ) + element.getValue() + " | " );
      }else
         array+=( element.getValue() + " | " );
      
      return array;
   }
   public boolean remove(){
      
      int object = JOptionPane.showConfirmDialog( null, "Do you want Remove?", "Remove Message", JOptionPane.YES_NO_OPTION);
      if( object == JOptionPane.NO_OPTION ){
         JOptionPane.showMessageDialog( null,"Remotion Canceled by User" ,"Canceled", 2);
      return false;
      }else{
         
         if( !isEmpty() ){
            JOptionPane.showMessageDialog( null, msgLIFO, "UnPack",0 );
               if( this.first == this.top ){
                  this.first = null;
                  JOptionPane.showMessageDialog( null, msgCleaning, titleClear, 0 );
               return true;
               }else{
                  Element temp = this.first;
                     while( temp.next != this.top )
                        temp = temp.next;
               
                     this.top = temp;
                     temp.next = null;
               
                  JOptionPane.showMessageDialog( null, msgRemoved);
                  return true;
               }
         }else
            return false;
      }
   }


   
   public static void main( String[] args ) {
      ListPile lp = new ListPile();
      lp.add();
      lp.add(  );
      lp.add(  );
      lp.add(  );
      
      lp.showArray();
      lp.remove();
      lp.showArray();
      
      
      
   }



   
}
