import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class SpellingBeeNYTSolver {

    // Checks if a word contains the yellow letter and any combination of gray letters
    public static boolean containsLetters(String word, String yellow, String gray) {
        for(char letter : word.toCharArray()) {
            if(!word.contains(yellow)) {
                return false;
            }
            if((letter != yellow.charAt(0)) && (gray.indexOf(letter) == -1)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws Exception {
        // Initialize file input/output stuff
        FileReader fileReader = new FileReader("english_dictionary.txt");
        FileWriter fileWriter = new FileWriter("outputFile.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Scanner input = new Scanner(System.in);

        // Prompt user for yellow and gray letters
        System.out.println("Welcome to Spelling Bee Word Finder!\n\n");
        System.out.println("What is the yellow letter?: ");
        String yellow = input.nextLine().trim().toLowerCase();
        System.out.println("What are the gray letters? (separated by spaces): ");
        String gray = input.nextLine().toLowerCase().replace(" ", "");

        // Write each word that contains at least one yellow letter and any combination of gray letters
        String word;
        while ((word = bufferedReader.readLine()) != null) {
            if(word.length() >= 4 && containsLetters(word, yellow, gray)) {
                bufferedWriter.write(word);
                bufferedWriter.newLine();
            }
        }

        // Close everything
        bufferedReader.close();
        bufferedWriter.close();
        input.close();
        
        // Tell user program successfully completed
        System.out.println("\nProgram complete!");
    }
}
