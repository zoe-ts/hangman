import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Words word=new Words();
        String secret=word.Read();


        int number=secret.length();
        char letter;
        int mistakes=0;
        int correct=0;
        ArrayList<Character> trials= new ArrayList<>();

        char[] reveal = new char[number];
        for (int i=0;i<number;i++){
            reveal[i]='_';
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess the secret word! It contains "+number+" letters!");

        while (mistakes<6 && correct!=number){
            int j=0;
            System.out.println("Give a letter:");
            letter = scanner.next().charAt(0);
            //check if letter is already used
            while (trials.contains(letter)){
                System.out.println("You have already tried this letter! \nYou are stupid. \n");
                System.out.println("Give a letter again:");
                letter = scanner.next().charAt(0);

            }
            trials.add(letter);
            int idx=secret.indexOf(letter);
            //checks if letter is in the word and its position
            if (idx>=0){
                reveal[idx]=letter;
                correct++;
                //check if letter exists multiple times in the word
                for(j=idx+1;j<number;j++){
                    if(secret.charAt(j)==letter){
                        reveal[j]=letter;
                        correct++;
                    }
                }
                System.out.println("The letter exists! The word now is:");
                for(char val: reveal) {
                    System.out.print(val + " ");
                }
                System.out.println("\n");
            }else{
                System.out.println("This letter is not in the word. Sorry dude.");
                System.out.println("Try again!");
                mistakes++;
                System.out.println("Watch out: You have done "+mistakes+" mistakes so far.");
            }
        }
        
        //ending messages
        if (mistakes==6){
            System.out.println("Too many mistakes! :( ");
            System.out.println("Maybe an other time my friend...");
            System.out.println("The secret word was: "+ secret);
        }
        if (correct==number){
            System.out.println("Congratulations!! :D");
            System.out.println("You found the secret word. I hope to see you again soon my friend!!");
        }


    }
}
