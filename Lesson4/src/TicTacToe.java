import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    private static final int fieldRange = 5;
    private static final char playerChip = 'X';
    private static final char aiChip = 'O';
    private static final char emptyPlace = '-';
    private static final int chipsForWin = 3;

    private static char[][] field = new char[fieldRange][fieldRange];

    public static void main(String[] args) {
     startGame();
    }

    static void startGame (){
        initFields();
        printField();

        while (true) {
            playerStep();
            printField();
            if (checkWin(playerChip)) {
                System.out.println("You win");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Draw");
                break;
            }
            aiStep();
            printField();
            if (checkWin(aiChip)) {
                System.out.println("ai win");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Draw");
                break;
            }
        }
    }

    static void initFields() {
        for (int i = 0; i < fieldRange; i++) {
            for (int j = 0; j < fieldRange; j++) {
                field[i][j] = emptyPlace;
            }
        }
    }

    static void printField() {
        for (int i = 0; i < fieldRange; i++) {
            System.out.print(" ");
            for (int j = 0; j < fieldRange; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("_________________________");
    }

    static void setSym(int y, int x, char sym) {
        field[y][x] = sym;
    }

    static void playerStep() {
        int x;
        int y;
        do {
            System.out.println(String.format("Enter coords X (1 - %s)",fieldRange));
            x = scanner.nextInt() - 1;
            System.out.println(String.format("Enter coords Y (1 - %s)",fieldRange));
            y = scanner.nextInt() - 1;
        } while (!isCellValid(y, x));
        setSym(y, x, playerChip);
    }

    static void aiStep() {
        for (int i = 0; i < fieldRange; i++)
            for (int j = 0; j < fieldRange; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, aiChip);
                    if (checkWin(aiChip)) return;
                    setSym(i, j, emptyPlace);
                }
            }
        for (int i = 0; i < fieldRange; i++)
            for (int j = 0; j < fieldRange; j++) {
                if (isCellValid(i, j)) {
                    setSym(i, j, playerChip);
                    if (checkWin(playerChip)) {
                        setSym(i, j, aiChip);
                        return;
                    }
                    setSym(i, j, emptyPlace);
                }
            }
        int x;
        int y;
        do {
            x = random.nextInt(fieldRange);
            y = random.nextInt(fieldRange);
        } while (!isCellValid(y, x));
        setSym(y, x, aiChip);
    }

    static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x > fieldRange - 1 || y > fieldRange - 1) {
            return false;
        }
        return field[y][x] == emptyPlace;
    }

    static boolean isFieldFull() {
        for (int i = 0; i < fieldRange; i++) {
            for (int j = 0; j < fieldRange; j++) {
                if (field[i][j] == emptyPlace) {
                    return false;
                }
            }
        }
        return true;
    }

    static boolean checkWin(char sym) {
        for (int i = 0; i < fieldRange; i++) {
            for (int j = 0; j < fieldRange; j++) {
                if (checkLine(i, j, 0, 1,  sym)) return true;
                if (checkLine(i, j, 1, 1,  sym)) return true;
                if (checkLine(i, j, 1, 0,  sym)) return true;
                if (checkLine(i, j, -1, 1, sym)) return true;
            }
        }
        return false;
    }

    static boolean checkLine(int y, int x, int vy, int vx, char sym) {
        int posX = x + (chipsForWin - 1) * vx;
        int posY = y + (chipsForWin - 1) * vy;
        if (posX < 0 || posY < 0 || posX > fieldRange - 1 || posY > fieldRange - 1) return false;
        for (int i = 0; i < chipsForWin; i++) {
            int itemY = y + i * vy;
            int itemX = x + i * vx;
            if (field[itemY][itemX] != sym) return false;
        }
        return true;
    }
}