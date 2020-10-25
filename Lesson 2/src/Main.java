public class Main {

    public static void main(String[] args) {

        //Task 1
        int sizeMass = (int) Math.round(Math.random() * 9) + 1; // Размерость массива
        int[] numsArray = changeNums(sizeMass);
        System.out.print("Массив чисел измененный - ");
        for (int i = 0; i < numsArray.length; i++) {
            System.out.print(numsArray[i]);
        }
        System.out.println("\n___________");

        //Task 2
        int[] filledArray = fillMas();
        System.out.println();
        for (int i = 0; i < filledArray.length; i++) {
            System.out.print(filledArray[i]);
        }
        System.out.println("\n___________");

        //Task 3
        int[] multipliedArr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        multiplyMassiveNums(multipliedArr);

        System.out.println();
        for (int i = 0; i < multipliedArr.length; i++) {
            System.out.print(multipliedArr[i]);
        }
        System.out.println("\n___________");

        //Task 4
        int[][] secondDimArray = new int[sizeMass][sizeMass];
        enterSecondDimArray(secondDimArray);
        secondDimArray = enterSecondDimArray(secondDimArray);

        for (int i = 0; i < secondDimArray.length; i++) {
            System.out.println();
            for (int j = 0; j < secondDimArray[i].length; j++) {
                System.out.print(secondDimArray[i][j] + " ");
            }
        }
        System.out.println("\n___________");

        //Task 5
        int[] arrMaxAndMin = new int[10];
        for (int i = 0; i < arrMaxAndMin.length; i++) {
            arrMaxAndMin[i] = (int) Math.round(Math.random() * 9);
            System.out.print(arrMaxAndMin[i]);
        }
        findArrMaxAndMin(arrMaxAndMin);
        System.out.println("\n___________");

        //Task 6
        for (int i = 0; i < arrMaxAndMin.length; i++) {
            arrMaxAndMin[i] = (int) Math.round(Math.random() * 9);
            System.out.print(arrMaxAndMin[i]);
        }
        System.out.println("\n" + checkBalance(arrMaxAndMin));
        System.out.println("\n___________");

        //Task 7
        int n = -2; //Сдвиг массива на n знаков
        int[] movedArray = moveArrayNums(n, arrMaxAndMin);

        for (int i = 0; i < arrMaxAndMin.length; i++) {
            System.out.print(movedArray[i]);
        }
    }

    //Task 1
    static int[] changeNums(int n) {

        System.out.print("Массив чисел иходный - ");

        int[] numsMassive = new int[n];
        for (int i = 0; i < numsMassive.length; i++) {
            numsMassive[i] = (int) Math.round(Math.random());
            System.out.print(numsMassive[i]);
        }

        for (int i = 0; i < numsMassive.length; i++) {
            if (numsMassive[i] == 0) numsMassive[i] = 1;
            else numsMassive[i] = 0;
        }
        System.out.println();

        return numsMassive;
    }

    //Task 2
    static int[] fillMas() {
        int[] emptyMas = new int[8];

        for (int i = 0; i < emptyMas.length; i++) {
            emptyMas[i] = i * 3;
        }

        return emptyMas;
    }

    //Task 3
    static int[] multiplyMassiveNums(int[] multipliedMas) {
        for (int i = 0; i < multipliedMas.length; i++) {
            if (multipliedMas[i] < 6) multipliedMas[i] *= 2;
        }

        return multipliedMas;
    }

    //Task 4
    /*
    1 0 0 0 1       [0][0] / [0][4]
    0 1 0 1 0       [1][1] / [1][3]
    0 0 1 0 0           [2][2]
    0 1 0 1 0       [3][1] / [3][3]
    1 0 0 0 1       [4][0] / [4][4]

    1 0 0 1
    0 1 1 0
    0 1 1 0
    1 0 0 1
     */
    static int[][] enterSecondDimArray(int[][] secondDimArray) {
        for (int i = 0; i < secondDimArray.length; i++) {
            for (int j = 0; j < secondDimArray[i].length; j++) {
                secondDimArray[i][i] = 1;
                secondDimArray[i][(secondDimArray[i].length - 1) - i] = 1;
            }
        }

        return secondDimArray;
    }

    //Task 5
    static void findArrMaxAndMin(int[] arrMaxAndMin) {
        int max = 0, min = 0;
        for (int i = 0; i < arrMaxAndMin.length; i++) {
            if (max < arrMaxAndMin[i]) max = arrMaxAndMin[i];
            if (min > arrMaxAndMin[i]) min = arrMaxAndMin[i];
        }

        System.out.println("\nМаксимальное: " + max);
        System.out.println("\nМинимальное: " + min);
    }

    //Task 6
    static boolean checkBalance(int[] arrMaxAndMin) {
        int sumLeft = 0;

        for (int i = 0; i < arrMaxAndMin.length; i++) {
            sumLeft += arrMaxAndMin[i];

            int sumRight = 0;
            for (int j = 0; j < arrMaxAndMin.length; j++) {
                if (j > i) sumRight += arrMaxAndMin[j];
                else sumRight += 0;
            }

            if (sumLeft == sumRight) return true;
        }
        return false;
    }

    //Task 7
    static int[] moveArrayNums(int n, int[] movedArray) {

        for (int i = 0; i < movedArray.length; i++) {
            System.out.print(movedArray[i]);
        }
        System.out.println();
        System.out.println("Сдвиг на " + n + " знака.");

        if (n > 0) {

            for (int i = 0; i < n; i++) {

                int buffer = movedArray[movedArray.length - 1];
                for (int j = movedArray.length - 1; j > 0; j--) {
                    movedArray[j] = movedArray[j - 1];
                }
                movedArray[0] = buffer;
            }

        } else if (n < 0) {

            for (int i = 0; i < n * (-1); i++) {

                int buffer = movedArray[0];
                for (int j = 0; j < movedArray.length - 1; j++) {
                    movedArray[j] = movedArray[j + 1];
                }
                movedArray[movedArray.length - 1] = buffer;
            }
        }

        return movedArray;
    }
}