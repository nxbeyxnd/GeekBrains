public class ArrayCalc {

    public void checkSize(String[][] values){
        checkSize(values.length);

        for (int i = 0; i < values.length; i++) {
            checkSize(values[i].length);
        }
    }

    private void checkSize(int lenght){
        if (lenght != 4) {
            throw new MyArraySizeException("Size must be exactly 4");
        }
    }

    public int calc(String[][] values){
        checkSize(values);

        int sum = 0;

        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                try {
                    sum += Integer.parseInt(values[i][j]);
                } catch (NumberFormatException e){
                    String message = String.format("Array[%s][%s] contains no digits",i,j);
                    throw new MyArrayDataException(message,e);
                }

            }
        }

        return sum;
    }
}
