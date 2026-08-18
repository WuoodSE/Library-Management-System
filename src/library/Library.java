
package library;

import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books; //Generics
    private ArrayList<Member> members;
   
   public  Library(){
       books= new ArrayList<>();
       members = new ArrayList<>();
   }
    
   public void addBook(Book book){
       books.add(book);
       
   }
   
   public void addMember(Member member) {
    members.add(member);
}
   
   public Member searchMemberById(int id) {

    for (Member member : members) {

        if (member.getMemberId() == id) {
            return member;
        }
    }

    return null;
}
   
   public boolean removeMember(int id) {

    Member member = searchMemberById(id);

    if (member != null && member.getBorrowedBooks().isEmpty()) {
        members.remove(member);
        return true;
    }

    return false;
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
 
public boolean borrowBook(int memberId, int bookId) {

    Member member = searchMemberById(memberId);
    Book book = SearchBookById(bookId);

    if (member == null || book == null) {
        return false;
    }

    if (!book.isAvailable()) {
        return false;
    }

    book.borrowBook(member);
    member.BorrowBook(book);

    return true;
}

 
public boolean returnBook(int memberId, int bookId) {

    Member member = searchMemberById(memberId);
    Book book = SearchBookById(bookId);

    if (member == null || book == null) {
        return false;
    }

    if (!member.hasBorrowed(book)) {
        return false;
    }

    member.returnBook(book);
    book.returnBook();

    return true;
}

public void displayMembers() {

    if (members.isEmpty()) {
        System.out.println("No members registered.");
        return;
    }

    System.out.println("========== Library Members ==========");

    for (Member member : members) {
        System.out.println(member);
    }
}

public void displayBorrowedBooks() {

    boolean found = false;

    for (Member member : members) {

        if (!member.getBorrowedBooks().isEmpty()) {

            found = true;

            System.out.println("\nMember: " + member.getMemberName());

            member.displayBorrowedBooks();
        }
    }

    if (!found) {
        System.out.println("No books are currently borrowed.");
    }
}

public void displayAvailableBooks() {

    boolean found = false;

    for (Book book : books) {

        if (book.isAvailable()) {

            found = true;
            System.out.println(book);
            System.out.println("-----------------------------------");
        }
    }

    if (!found) {
        System.out.println("No books are currently available.");
    }
}
 
}
