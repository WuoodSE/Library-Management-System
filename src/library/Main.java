
package library;
import java.util.Scanner;
public class Main {
   public static void main(String[] args){
     Scanner input = new Scanner(System.in); 
     
      Library library= new  Library();
       
       library.addBook(new Book(1,"Clean code","Robert C.Martin"));
       library.addBook(new Book(2,"Java Basics","John Smith"));
       library.addBook(new Book(3,"Design Pattern","GoF"));

       int choice;
  do{
      
      System.out.println("\n================  Library Menu  =================");
          System.out.println("1.Display Books");
          System.out.println("2.Add Book");
          System.out.println("3.Search Book by ID");
          System.out.println("4.Search Book by Title");
          System.out.println("5.Remove Book");
          System.out.println("6.Borrow Book");
          System.out.println("7.Return Book");
          System.out.println("0.Exit");
          
          System.out.println("Enter your Choice");
          choice=input.nextInt();
          switch(choice){
              case 1:
          library.displayBooks();
          break;
                  
              case 2:
          System.out.println("Enter Book ID: ");
          int id =input.nextInt();
          input.nextLine();
          
          System.out.println("Enter Book Title: ");
          String title =input.nextLine();
          
          System.out.println("Enter Author Name: ");
          String Author =input.nextLine();
          
          Book newBook= new Book(id,title,Author) ;
          library.addBook(newBook);
          System.out.println("Book Added Successfully ");
          break;
          
              case 3:
          System.out.println("Enter Book ID: ");
          int searchId= input.nextInt();
                            
          Book foundBook= library.SearchBookById(searchId);
          if(foundBook != null){
          System.out.println(foundBook);
           }else{
          System.out.println("Book not found");
          }
          break;
          

              case 4:
          input.nextLine();
                  
          System.out.println("Enter Book Title: ");
          String searchTitle= input.nextLine();
                            
          Book foundTitle= library.SearchBookByTitle(searchTitle);
          if(foundTitle != null){
          System.out.println(foundTitle);
          }else{
          System.out.println("Book not found");
          }
          break;
          
               case 5:
                  
          System.out.println("Enter Book ID: ");
          int removeId= input.nextInt();
                            
          if(library.removeBook(removeId)){
          System.out.println("Book removed successfully");
          }else{
          System.out.println("Book not found");
          }
          break;
                   
                case 6:
                  
          System.out.println("Enter Book ID: ");
          int borrowId= input.nextInt();
                            
          if(library.borrowBook(borrowId)){
          System.out.println("Book borrowed successfully");
          }else{
          System.out.println("Book is not Available ");
          }
          break;
               
                 case 7:
                  
          System.out.println("Enter Book ID: ");
          int returnId= input.nextInt();
                            
          if(library.returnBook(returnId)){
          System.out.println("Book returned successfully");
          }else{
          System.out.println("Book is already Available or not found");
          }
          break;

                  case 0:
                  System.out.println("Goodbye !");
                  break;
              default:
                  System.out.println("Invalid Choice ");

          }// end switch

  }while(choice !=0);
  
   } 
}

 
  
