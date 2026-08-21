
package library;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class Library {
    private ArrayList<Book> books; //Generics
    private ArrayList<Member> members;
    private final String fileName= "books.txt";
   
   public  Library(){
       books= new ArrayList<>();
       members = new ArrayList<>();
       loadBooksFromFile();
   }
    public boolean isEmpty(){
        return books.isEmpty();
    }
   public void addBook(Book book){
       books.add(book);
       saveBooksToFile();
       
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
         saveBooksToFile();
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
    saveBooksToFile();

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
    saveBooksToFile();

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
 
public void saveBooksToFile() {

    try (FileWriter writer = new FileWriter(fileName)) {

        for (Book book : books) {

            writer.write(
                book.getId() + "|" +
                book.getTitle() + "|" +
                book.getAuthor() + "|" +
                book.isAvailable() + "\n"
            );
        }

        System.out.println("Books saved successfully");

    } catch (IOException e) {

        System.out.println("Error saving books: " + e.getMessage());
    }
}

public void loadBooksFromFile() {

    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

        String line;

        while ((line = reader.readLine()) != null) {

            String[] data = line.split("\\|");

            int id = Integer.parseInt(data[0]);
            String title = data[1];
            String author = data[2];
            boolean available = Boolean.parseBoolean(data[3]);

            Book book = new Book(id, title, author);
            book.setAvailable(available);

            books.add(book);
        }

        System.out.println("Books loaded successfully");

    } catch (IOException e) {

        System.out.println("No saved books found. Starting with an empty library.");

    }
}




}
