public class Task {
    public int[] checkArray(int[] baseMass) throws RuntimeException {
        int[] result;
        int indexBorderElem = baseMass.length - 1;
        for (int i = 0; i < baseMass.length; i++) {
            if (baseMass[baseMass.length - i - 1] == 4) {
                indexBorderElem = baseMass.length - i - 1;
                break;
            }
        }
        if ((baseMass.length - indexBorderElem - 1) == 0) {
            throw new RuntimeException("mass without border element!");
        }
        result = new int[baseMass.length - indexBorderElem - 1];
        for (int j = result.length - 1; j >= 0; j--) {
            result[j] = baseMass[baseMass.length - 1 - j];
        }
        return result;
    }

    public boolean findDigits(int[] baseMass) {
        boolean value4 = false;
        boolean value1 = false;
        for (int element : baseMass) {
            if (element == 4) {
                value4 = true;
            }
            if (element == 1) {
                value1 = true;
            }
        }
        return value1 && value4 ? true : false;
    }

}