import java.util.Scanner;

public class CurrencyConverter {
    
    public static void main(String[] args) {
        Operations oper = new Operations();
        oper.operation();
    }
}


class CurrencyConversion{
    double conversionC(double cr, double amount){
        double convertedAmount = (double)(cr * amount);
        return convertedAmount;
    }
    void currencyConversion(double amount, String n, String m){
        double result = 0;
        if(n.equals("INR") && m.equals("USD")){
            result = conversionC(0.012, amount);
        }
        else if(n.equals("INR") && m.equals("EUR")){
            result = conversionC(0.010, amount);
        }
        else if(n.equals("USD") && m.equals("INR")){
            result = conversionC(86.21, amount);
        }
        else if(n.equals("USD") && m.equals("EUR")){
            result = conversionC(0.86, amount);
        }
        else if(n.equals("EUR") && m.equals("INR")){
            result = conversionC(100.13, amount);
        }
        else if(n.equals("EUR") && m.equals("USD")){
            result = conversionC(1.16, amount);
        }
        System.out.printf("\n\n[%s] : %.3f \n \t to \n[%s] : %.3f", n, amount, m, result);
    }
}
class Operations{
    @SuppressWarnings("ConvertToTryWithResources")
    void operation(){
        CurrencyConversion cc = new CurrencyConversion();
        String[] curr = {"INR", "USD", "EUR"};
        Scanner inp = new Scanner(System.in);
        int n, m;
        char choice;
        double amount;
        do { 
            
            do { 
                System.out.print("Enter Amount : ");
                amount = inp.nextDouble();
                if(amount < 0){
                    System.out.print("Please, Enter Positive Amount. 🤨.\n\n");
                }
                else if (amount == 0) {
                    System.out.println("Please, Enter Amount Greater than '0'. 🤨.\n\n");
                }
                else{
                    break;
                }
            } while (true);
            System.out.println("\nAvailble Conversions : ");
            for(int i = 0 ; i < curr.length ; i++ ){
                System.out.println((i+1) + ". " + curr[i]);
            }
            do{
                System.out.print("\nSelect Your choice [1, 2, 3], From : ");
                n = inp.nextInt();
                System.out.print("To : ");
                m = inp.nextInt();
                if (n == m) {
                    System.out.println("Please select different Types of Currencies, Thank You! '_'\n");
                }
                else if(n-1 >= 0 && n-1 <= 2 && m-1 >= 0 && m-1 <= 2){
                    break;
                }
                else{
                    System.out.println("Enter Valid Currency Number. Thank You! 🤨\n");
                }
            }while(true);
            cc.currencyConversion(amount, curr[n-1], curr[m-1]);
            System.out.print("\n\nDo you want Continue? [y/n] : ");
            choice = inp.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
        System.out.println("Thanks For Using Our Currency Converter. 😊");
        inp.close();
    }
}
