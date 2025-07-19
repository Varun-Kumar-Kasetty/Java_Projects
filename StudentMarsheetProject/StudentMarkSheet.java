
import java.util.Scanner;

public class StudentMarkSheet {

    public static void main(String[] args) {
        InputDetails input = new InputDetails();
        input.inputDetails();
    }
}




class InputDetails {

    void inputDetails() {
        Scanner inp = new Scanner(System.in);
        String[] subjects = {"Telugu", "Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Social Studies"};
        int subLen = subjects.length;
        char choice;

        do {
            System.out.println("Subjects : ");
            for (int i = 0; i < subLen; i++) {
                System.out.print(i + 1 + ". " + subjects[i] + ".\n");
            }
            System.out.println("Enter Marks with Space.");
            for (String s : subjects) {
                System.out.print(s + " ");
            }
            String[] marksSt = inp.nextLine().split(" ");
            for (String )
                System.out.print("\n\nDo you want continue? [y/n] : ");
            choice = inp.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }
}
