
package library;


public class Member {
    
   private int memberId;
   private String memberName;
   
   public Member(int memberId,String memberName ){
       this.memberId= memberId;
       this.memberName=memberName;
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
    
    public void displayMember(){
        
      System.out.println("Member ID; "+memberId);
      System.out.println("Member Name; "+memberName);

    }
}
