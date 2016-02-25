import java.util.Scanner;
public class Fun {

    public static void main(String[] args) {
        
        System.out.println("Welcome to Gabe's Bank! Lets create an acount for you!");
        System.out.println("What is your name");
        Scanner name = new Scanner(System.in);
        String name1 = name.nextLine();
        System.out.println("Whats your password?");
        Scanner password = new Scanner(System.in);
        String password1 = name.nextLine();
      
        Person acount = new Person(name1,password1);
        while(true){
            System.out.println("What do you want to do? (deposit, withdraw, balance)");
            Scanner doing = new Scanner(System.in);
            String obj = doing.nextLine();
            switch(obj){

                case "deposit":
                    System.out.println("What is your password?");
                    Scanner pin = new Scanner(System.in);
                    String pin2 = pin.nextLine();
                    
                    System.out.println("How much to deposit?");
                    Scanner amount = new Scanner(System.in);
                    float amount2 = amount.nextFloat();
                    
                    System.out.println(acount.deposit(pin2,amount2));
                    break;
                
                case "withdraw":
                    System.out.println("What is your password?");
                    Scanner pin3 = new Scanner(System.in);
                    String pin4 = pin3.nextLine();
                    
                    System.out.println("How much to withdraw?");
                    Scanner amount3 = new Scanner(System.in);
                    float amount4 = amount3.nextFloat();
                    
                    System.out.println(acount.withdrawl(pin4,amount4));
                    break;
                
                case "balance":
                    System.out.println("What is your password?");
                    Scanner auth = new Scanner(System.in);
                    String auth1 = auth.nextLine();
                    System.out.println(acount.getBalance(auth1));

            }
         
        }
        }
    
    }
    


class Person {
    String name;
    private String password;
    private long balance;
   
    
   public Person(String nameIn, String passwordIn){
         name = nameIn;
         password = passwordIn;
    }
    public String say(){
       return("Hello my name is "+name+".");
    }
    public String getName(){
        return name;
    }
  public String withdrawl(String passcode, float amount){
      if (passcode.equals(password) && amount > 0 && balance - amount >0){
          //take money
          balance -= amount;
          return "Your balance is: $"+balance;
      }else{
          return "Error insufficient funds.";
      }
      
  }
  public String deposit(String passcode, float amount){
      if (passcode.equals(password) && amount > 0){
          //take money
          balance += amount;
          return "Your balance is: $"+balance;
      }else{
          return "Error wrong password.";
      }
     
  }
  public String getBalance(String pin){
      if(pin.equals(password)){
          
      
      return name+" has $"+balance+" in the bank";
  }else{
          return "Error";
      }
  }
}


