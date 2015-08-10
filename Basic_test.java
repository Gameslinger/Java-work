import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
public class test {
    
    public static void main(String[] args) {
        System.out.println("Hello whats your name?\n (put it in the box)");
        Scanner hello = new Scanner(System.in);
        String hello1 = hello.nextLine();
        
      System.out.println("Welcome to the test "+hello1+", would you like to start? Yes or No?");
      Scanner first = new Scanner(System.in);
       int number = 0;
     String first1 = first.nextLine();
     if (first1.equals("Yes") || first1.equals("yes")) {
         System.out.println("question one: what is 5 - 3?");
         Scanner second = new Scanner(System.in);
         int second1 = second.nextInt();
         number++;
         if (second1 == 2) {
           
             System.out.println("Correct! Number 2: what is 5 X 5?");
             Scanner third = new Scanner(System.in);
             int third1 = third.nextInt();
             number++;
             if (third1 == 25) {
                  
                 System.out.println("Correct! Number 3: whats the last name of the current presedent?");
                 Scanner forth = new Scanner(System.in);
                 String forth1 = forth.nextLine();
                 if (forth1.equals("Obama") || forth1.equals("obama") ) {
                   System.out.println("Correct! What is the capatal of the U.S.");
                   Scanner fifth = new Scanner(System.in);
                   String fifth1 = fifth.nextLine();
                         number++;
                    if (fifth1.equals("DC")||fifth1.equals("Dc")||fifth1.equals("D.C.")|| fifth1.equals("D.C") || fifth1.equals("dc")) {
                    number++;
                     System.out.println("You got them all right!");
                     end(number);
                 } else {
                         end(number);
                         }
                    
                     
                 } else {
                     end(number);
                 }
                 number++;
                 
             } else {
                 end(number);
             }
         } else {
             end(number);
     }
      
     } else {
         end(number);
     }
}
    public static void end( int gg) {
     System.out.println("you got: " +gg+" right! Did You like it? (Yes or No)");
     Scanner done = new Scanner(System.in);
     String done1 = done.nextLine();
     if (done1.equals("Yes") || done1.equals("yes")) {
         System.out.println("Thanks this is my first program!");
     } else {
         System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVV");
         for (int j = 0; j <10; j++) {
         System.out.println(">>>>>>RAGE QUIT!!!!<<<<<<");
        
         
     }
         System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^");
         System.out.println("GOOD BYE :3");
         try {
             Thread.sleep(1100);
         } catch (InterruptedException ex) {
             Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
         }
         int x = 1/0;
        
                  
          }   
         }
        
 }
