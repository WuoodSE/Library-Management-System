
package library;

import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books; //Generics
   
   public  Library(){
       books= new ArrayList<>();
   }
    
   public void addBook(Book book){
       books.add(book);
       System.out.println("Book added successfully ");
       
   }
   
   public void displayBooks(){
       if(books.isEmpty()){
         System.out.println("No books available ");
         return;
       }
       
       for(Book book : books){
        System.out.println(book);
       System.out.println("-----------------------------");

       }  
   }
   
   
}
