
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
 public Book SearchBookById(int id){
     for(Book book: books){
     if(book.getId()==id){
         return book;
     }
     }
     return null;
 } 
 public Book SearchBookByTitle(String title){
     for(Book book: books){
     if(book.getTitle().equalsIgnoreCase(title)){
         return book;
     }
     }
     return null;
 } 
}
