import java.util.Random;
import java.util.Scanner;

class ATM{
    Scanner inp = new Scanner(System.in);
    double amount;
    
    Random random = new Random();
    int minOTP = 100000;
    int maxOTP = 999999;
    public void deposit(double depo) {
        double amt = 0;
            do{
                int n = random.nextInt(maxOTP - minOTP + 1) + minOTP;
                System.out.println("Your OTP is " + n);
                System.out.print("\nEnter OTP : ");
                int otp = inp.nextInt();
            
                if(n == otp){
                    break;
                }
                else{
                    System.out.println("You entered Wrong OTP, Please Enter Newly Generated OTP.");
                }
            }while(true);
            System.out.println("Amount Deposited Successfully.\nAmount Deposited : " + depo);
            amt += depo;
            amount += amt;
        }


    public void withdraw(double with) {
        if (with > amount) {
            System.out.println("Insufficient Balance.");
        }
        else{
            do{
                int n = random.nextInt(maxOTP - minOTP + 1) + 1;
                System.out.println("Your OTP is " + n);
                System.out.print("\nEnter OTP : ");
                int otp = inp.nextInt();
            
                if(n == otp){
                    break;
                }
                else{
                    System.out.println("You entered Wrong OTP, Please Enter Newly Generated OTP.");
                }
            }while(true);
            System.out.println("Amount Withdrawn Successfully.\nAmount Withdrawn : " + with);
            this.amount -= with;
        }
    }

    public void amount() {
        System.out.println("Balance : " + amount + "/-.");
    }
    
}

class Operation{
    void operations(){
        Scanner inp = new Scanner(System.in);
        char choice;
        SwitchClass sc = new SwitchClass();
        do {
            System.out.println("Operations Available : ");
            System.out.println("1. Deposit Amount.");
            System.out.println("2. Withdraw Amount.");
            System.out.println("3. Check Balance.");
            System.out.print("Enter the Operation You want To Perform [1, 2, 3] : ");
            char op = inp.next().charAt(0);
            System.out.println("\n");
            do{
            if(op == '1' || op == '2' || op == '3'){
                sc.switchCase(op);
                break;
            }
            else{
                System.out.println("Enter Valid Operation");
            }
            }while(true);
            System.out.print("\n\nDo you Want To Continue [y/n] : ");
            choice = inp.next().charAt(0);
            System.out.println("\n");
        } while (choice == 'y' || choice == 'Y');
        
    }
}
class SwitchClass{
    ATM atm = new ATM();
    void switchCase(char op){
        
        Scanner inp = new Scanner(System.in);
        switch (op) {
            case '1' -> {
                System.out.print("Enter Amount to deposit :  ");
                double dep = inp.nextDouble();
                atm.deposit(dep);
            }
            case '2' -> {
                System.out.print("Enter Amount to Withdraw :  ");
                double wit = inp.nextDouble();
                atm.withdraw(wit);
            }
            case '3' -> atm.amount();
            default -> System.out.println();
        }
    }
}

public class ATMSimulation {
    public static void main(String[] args) {
        Operation op = new Operation();
        op.operations();
    }
}
