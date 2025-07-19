
import java.util.Scanner;

public class Calculator{
    public static void main(String[] args) {
        GetUserInput gui = new GetUserInput();
        gui.getUserInput();
    }
}

class GetUserInput{
    void getUserInput(){
        Scanner inp = new Scanner(System.in);
        char choice;
        double firstNumber, secondNumber;
        Perform per = new Perform();

        do { 
            System.out.print("Enter First Number : ");
            firstNumber = inp.nextInt();
            System.out.print("\nEnter Second Number : ");
            secondNumber = inp.nextInt();
            System.out.println("\n\nAvaible Operations in this Calculator");
            System.out.printf("1. Addition [ + ]\n");
            System.out.printf("2. Subraction [ - ]\n");
            System.out.printf("3. Multiplication * ]");
            System.out.printf("4. Division to get Quoetient [ / ]\n");
            System.out.print("5. Division to get Remainder [ % ]\n");
            System.out.printf("6. Exponent [ ^ ]\n");
            System.out.print("Choose Operation to Perform [ + , - , * , / , % , ^]: ");
            choice = inp.next().charAt(0);
            per.perform(firstNumber, secondNumber, choice);
            System.out.print("\n\nDo you want to Continue to Use Calculator ( y / Y ) : ");
            choice = inp.next().charAt(0);
            System.out.println("\n\n");

        } while (choice == 'y' || choice == 'Y');
    }
}
class Perform{
    void perform(double fN, double sN, char c){
        Operations op = new Operations();
        double result;
        switch (c) {
            case '+' -> {
                result = op.addition(fN, sN);
                System.out.printf("\n\n%.2f + %.2f = %.2f", fN, sN, result);
            }
            case '-' -> {
                result = op.subraction(fN, sN);
                System.out.printf("\n\n%.2f - %.2f = %.2f", fN, sN, result);
            }
            case '*' -> {
                result = op.multiplication(fN, sN);
                System.out.printf("\n\n%.2f * %.2f = %.2f", fN, sN, result);
            }
            case '/' -> {
                if(sN!=0){
                    result = op.divisionQuoetient(fN, sN);
                    System.out.printf("\n\n%.2f / %.2f = %.2f", fN, sN, result);
                }
                else{
                    System.out.println("Denominator is '0' Division is Indetermined");
                }
            }
            case '%' -> {
                result = op.divisionRemainder(fN, sN);
                System.out.print("\n\n" + fN + " % " + sN + " = " + result);
            }
            case '^' -> {
                result = op.exponent(fN, sN);
                System.out.printf("\n\n%.2f ^ %.2f = %.2f", fN, sN, result);
            }
            default -> System.out.println("Enter Valid Numbers and Operations");
        }
    }
}
class Operations{
    double addition(double fN, double sN){
        return (fN + sN);
    }
    double subraction(double fN, double sN){
        return (fN - sN);
    }
    double multiplication(double fN, double sN){
        return (fN * sN);
    }
    double divisionQuoetient(double fN, double sN){
        return (fN / sN);
    }
    double divisionRemainder(double fN, double sN){
        return (fN % sN);
    }
    double exponent(double fN, double sN){
        if( sN == 1 ){
            return fN;
        }
        return fN * exponent(fN, sN - 1);
    }
}