import java.util.Scanner;

public class Hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordToGuess = "I love cats";
        StringBuilder hiddenWord = new StringBuilder(wordToGuess.replaceAll("[^ ]", "_"));
        int attempts = 6;
        boolean wordGuessed = false;

        System.out.println("Welcome to Hangman!");
        System.out.println("The word to guess is: " + hiddenWord);
        System.out.println();

        while (attempts > 0 && !wordGuessed) {
            System.out.print("Guess a letter or the whole word: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.length() > 1) {
                if (input.equals(wordToGuess.toLowerCase())) {
                    hiddenWord = new StringBuilder(wordToGuess);
                    wordGuessed = true;
                } else {
                    attempts--;
                    System.out.println("That was the incorrect guess! You have " + attempts + " attempts left.");
                }
            } else if (input.length() == 1) {
                char guess = input.charAt(0);
                boolean correctGuess = false;

                for (int i = 0; i < wordToGuess.length(); i++) {
                    if (Character.toLowerCase(wordToGuess.charAt(i)) == guess) {
                        hiddenWord.setCharAt(i, wordToGuess.charAt(i));
                        correctGuess = true;
                    }
                }

                if (correctGuess) {
                    System.out.println("Correct guess! The word so far: " + hiddenWord);
                } else {
                    attempts--;
                    System.out.println("Incorrect guess! You have " + attempts + " attempts left.");
                }
            }

            if (hiddenWord.toString().equals(wordToGuess)) {
                wordGuessed = true;
                System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
            }

            System.out.println();
        }

        if (!wordGuessed) {
            System.out.println("Sorry, you've run out of attempts. The correct word was: " + wordToGuess);
        }

        scanner.close();
    }
}
