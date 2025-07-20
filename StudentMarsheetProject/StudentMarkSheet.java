
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
        MarkSheet mrks = new MarkSheet();
        String[] subjects = {"Tel", "Hin", "Eng", "Mat", "Phy", "Che", "Bio", "Soc"};
        int subLen = subjects.length;
        char choice;
        double[] marks = new double[subjects.length];
        int c = 0;
        String[] marksSt;
        do {
            System.out.println("Subjects : ");
            for (int i = 0; i < subLen; i++) {
                System.out.print(i + 1 + ". " + subjects[i] + ".\n");
            }
            System.out.println("Enter Marks with Space.");
            for (String subject : subjects) {
                System.out.print(subject + " ");
            }
            System.out.println();
            marksSt = inp.nextLine().split(" ");
            for (String st : marksSt){
                marks[c] = Double.parseDouble(st);
                c++;
            }
            System.out.println();
            for(double d : marks){
                System.out.print(d + " ");
            }
            mrks.displayMarkSheet(marks);
            System.out.print("\n\nDo you want continue? [y/n] : ");
            choice = inp.next().charAt(0);
        } while (choice == 'y' || choice == 'Y');
    }
}


class MarkSheet{
    void displayMarkSheet(double[] markss){
        String[] subs = {"Tel", "Hin", "Eng", "Mat", "Phy", "Che", "Bio", "Soc"};
        double sum = 0;
        Grade g = new Grade();
        int c = 0;
        char[] grades = new char[subs.length];
        for(double mark : markss){
            sum += mark;
            grades[c] = g.grade(mark);
            c++;
        }
        double avg = sum/markss.length;
        System.out.println("\n----  MarskSheet  ----");
        for(int i = 0 ; i < markss.length ; i++){
            System.out.println("| "+ (i+1) + " | " + subs[i] + " | " + markss[i] + " |" + grades[i] + " |");
        }
        char finalGrade = 'S';
        for(char gra : grades){
            if(gra == 'F'){
                finalGrade = 'F';
            }
            else{
                finalGrade = g.grade(avg);
            }
        }
        System.out.println("Total Marks   : " + sum);
        System.out.println("Average Marks : " + avg);
        System.out.println("Overall Grade : " + finalGrade);

    }
}

class Grade{
    char grade(double mark){
        if(mark >= 95 && mark <= 100){
            return 'S';
        }
        else if(mark >= 90 && mark < 95){
            return 'A';
        }
        else if(mark >= 80 && mark < 90){
            return 'B';
        }
        else if(mark >= 70 && mark < 80){
            return 'C';
        }
        else if(mark >= 60 && mark < 70){
            return 'D';
        }
        else if(mark >= 50 && mark < 60){
            return 'E';
        }
        else{
            return 'F';
        }
    }
}