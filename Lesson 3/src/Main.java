import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        chooseTheGame();
    }

    private static void chooseTheGame() {
        System.out.println("Choose the game:");
        System.out.println("1 - Guess the num");
        System.out.println("2 - Guess the word");
        System.out.println("0 - exit");
        int game = scanner.nextInt();
        if (game == 1) guessTheNum();
        else if (game == 2) guessTheWord();
        else if (game == 0) return;
        else {
            System.out.println("Incorrect!");
            chooseTheGame();
        }
    }

    static void guessTheNum() {
        int randomNum = new Random().nextInt(10);
        int tryCount = 3, enterNum;

        System.out.println("Enter num");
        enterNum = scanner.nextInt();
        for (int i = 0; i < tryCount; i++) {
            if (enterNum == randomNum) {
                System.out.println("You win!");
                break;
            } else if (tryCount - 1 == i) {
                System.out.println("You lose!");
            } else if (enterNum < randomNum) {
                System.out.println("Num is above, you have " + (tryCount - 1 - i) + " attempt");
                enterNum = scanner.nextInt();
            } else if (enterNum > randomNum) {
                System.out.println("Num is less, you have " + (tryCount - 1 - i) + " attempt");
                enterNum = scanner.nextInt();
            }
        }

        System.out.println("Restart?");
        int chooseAction = scanner.nextInt();
        if (chooseAction == 1) guessTheNum();
        else chooseTheGame();
    }

    static void guessTheWord() {
        String randomWord = setRandomWord();
        int tryCount = 10;
        System.out.println("Enter word");

        String userWord = scanner.next();

        System.out.println("Random word: " + randomWord);
        System.out.println("Used word: " + userWord);

        if (randomWord.equals(userWord)) {
            System.out.println("You win!");
            return;
        }

        for (int i = 0; i < randomWord.length(); i++) {
            if (userWord.length() > 1) {
                if (randomWord.charAt(i) == userWord.charAt(i)) {
                    System.out.print(randomWord.charAt(i));
                } else {
                    System.out.print("#");
                }
            }
        }
        System.out.println("######");

        System.out.println("Restart?");
        int chooseAction = scanner.nextInt();
        if (chooseAction == 1) guessTheWord();
        else chooseTheGame();
    }

    static String setRandomWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        return words[new Random().nextInt(words.length)];
    }
}