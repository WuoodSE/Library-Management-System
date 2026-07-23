
package library;

public class Main {
   public static void main(String[] args){
       
      Library library= new  Library();
       
       Book book1= new Book(1,"Clean code","Robert C.Martin");
       Book book2= new Book(2,"Java Basics","John Smith");
       Book book3= new Book(3,"Design Pattern","GoF");
      library.addBook(book1);
      library.addBook(book2);
      library.addBook(book3);
      library.displayBooks();

Book foundBook= library.SearchBookById(2);
if(foundBook!= null){
    System.out.println(foundBook);
}else{
System.out.println("Book not found ");
}
  
Book findBook= library.SearchBookByTitle("java");
if(findBook!= null){
    System.out.println(findBook);
}else{
System.out.println("Book not found ");
}
                     


       
       
   
   } 
}
