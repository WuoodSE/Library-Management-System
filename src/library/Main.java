
package library;
import java.util.Scanner;
public class Main {
   public static void main(String[] args){
     Scanner input = new Scanner(System.in); 
     
      Library library= new  Library();
      
      Member m1 = new Member(1, " Wuood");
      Member m2 = new Member(2, " Norah");
      
       library.addMember(m1);
       library.addMember(m2);       
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
          System.out.println("8.Add Member");
          System.out.println("9.displayMembers");
          System.out.println("10.Borrow Book ");
          System.out.println("11.Display Borrowed Books");
          System.out.println("12.Display Available Books");
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
          System.out.println("Enter Member ID: ");
          int memberId= input.nextInt();

                            
          if(library.borrowBook(borrowId,memberId)){
          System.out.println("Book borrowed successfully");
          }else{
          System.out.println("Book is already Available or Book or member not found");
          }
          break;
               
                 case 7:
                  
          System.out.println("Enter Book ID: ");
          int returnId= input.nextInt();
          System.out.println("Enter Member ID: ");
          int MemberId= input.nextInt();

                            
          if(library.returnBook(returnId,MemberId)){
          System.out.println("Book returned successfully");
          }else{
          System.out.println("Book is already Available or Book or member not found");
          }
          break;
          
          case 8:

    System.out.print("Enter Member ID: ");
    int memId = input.nextInt();
    input.nextLine();

    System.out.print("Enter Member Name: ");
    String memberName = input.nextLine();

    Member member = new Member(memId, memberName);
    library.addMember(member);

    System.out.println("Member added successfully.");

    break;
    
    case 9:

    library.displayMembers();

    break;
    
    case 10:

    System.out.print("Enter Member ID: ");
    int borrowMemberId = input.nextInt();

    System.out.print("Enter Book ID: ");
    int borrowBookId = input.nextInt();

    if (library.borrowBook(borrowMemberId, borrowBookId)) {
        System.out.println("Book borrowed successfully.");
    } else {
        System.out.println("Unable to borrow the book.");
    }

    break;
   
    case 11:

    library.displayBorrowedBooks();

    break;
    
    case 12:

    library.displayAvailableBooks();

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

 
  
