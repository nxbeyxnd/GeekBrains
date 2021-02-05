import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TaskTests {
    private Task exampleForJUnit;
    private boolean expected;

    @BeforeEach
    public void init() {
        expected = false;
        exampleForJUnit = new Task();
    }

    @ParameterizedTest
    @MethodSource("dataForCheckArray")
    public void testcheckArray(int[] resultMass, int[] mass) {
        Assertions.assertArrayEquals(resultMass, exampleForJUnit.checkArray(mass));
    }

    public static Stream<Arguments> dataForAfterPast4massTest() {
        List<Arguments> out = new ArrayList<>();
        int[] resultMass = new int[]{7, 1}, mass = new int[]{1, 2, 3, 4, 1, 7};
        int[] resultMass1 = new int[]{7, 1, 2}, mass1 = new int[]{1, 2, 4, 2, 1, 7};
        int[] resultMass2 = new int[]{7}, mass2 = new int[]{1, 4, 7};

        out.add(Arguments.arguments(resultMass, mass));
        out.add(Arguments.arguments(resultMass1, mass1));
        out.add(Arguments.arguments(resultMass2, mass2));
        return out.stream();
    }

    @Test
    public void testcheckArrayWithoutBorderElement() {
        int[] mass = new int[]{1, 2, 3};
        Assertions.assertThrows(RuntimeException.class, () -> exampleForJUnit.checkArray(mass));
    }

    @ParameterizedTest
    @MethodSource("dataFindDigits")
    public void testHavingBorderElement(boolean value, int[] mass) {
        Assertions.assertEquals(value, exampleForJUnit.findDigits(mass));
    }

    public static Stream<Arguments> dataFindDigits() {
        List<Arguments> out = new ArrayList<>();
        int[] mass = new int[]{1, 2, 3, 4, 1, 7};
        int[] mass1 = new int[]{2, 2, 2, 2};
        int[] mass2 = new int[]{1, 2, 2, 2};
        out.add(Arguments.arguments(true, mass));
        out.add(Arguments.arguments(false, mass1));
        out.add(Arguments.arguments(false, mass2));
        return out.stream();
    }
}
