
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
 public boolean removeBook(int id){
     Book book = SearchBookById(id);
     
     if(book!= null){
         books.remove(book);
         return true;
     }
    return false; 
 }
 
          public boolean borrowBook(int id){
             
             Book book= SearchBookById(id);
             
             if(book != null && book.isAvailable() ){
                 book.borrowBook();
                 return true;
             }
             return false;
         }
 
          public boolean returnBook(int id){
              
             Book book =SearchBookById(id);
             
             if(book != null && !book.isAvailable()){
                 book.returnBook();
             return true;
          }
          return false;
          }
 
}
