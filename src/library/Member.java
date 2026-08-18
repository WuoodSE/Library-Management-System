
package library;

import java.util.ArrayList;
public class Member {
    
   private int memberId;
   private String memberName;
   private ArrayList<Book> borrowedBooks;
   
   
   public Member(int memberId,String memberName ){
       this.memberId= memberId;
       this.memberName=memberName;
       this.borrowedBooks = new ArrayList<>();
       
   }
   
   
   public void BorrowBook(Book book){
       borrowedBooks.add(book);
 
   }
   
     public void returnBook(Book book){
       borrowedBooks.remove(book);
 
   } 
     
     public void displayBorrowedBooks(){
       
         if(borrowedBooks.isEmpty()){
             System.out.println(" No borrowed books ");
             return;
         }
             System.out.println(" borrowed books ");
             for(Book book : borrowedBooks){
              System.out.println(book);
             }
     }
     
     public boolean hasBorrowed(Book book) {
    return borrowedBooks.contains(book);
}
     public ArrayList<Book> getBorrowedBooks() {
    return borrowedBooks;
}

   
   public int getMemberId(){
       return memberId;
   }
   public String getMemberName(){
       return memberName;
   }
   public void setmemberId(int id){
       memberId=id;
   }
    public void setmemberName(String name){
       memberName=name;
   }  
    
@Override
public String toString() {
    return "Member ID: " + memberId +", Name: " + memberName +", Borrowed Books: " + borrowedBooks.size();
}
}
