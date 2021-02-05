import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ExecutingTest {
    private static int valBefore = 0;
    private static int valAfter = 0;

    public static void start(Class someClass) {
        Method[] methods = someClass.getDeclaredMethods();
        List<Method> listCurrentAnnotation = new ArrayList<>();
        List<Method> listTestAnnotation = new ArrayList<>();

        creatingMethodMass(methods, listCurrentAnnotation, listTestAnnotation);
        executeAnnotations(listCurrentAnnotation, someClass);


    }

    private static void executeAnnotations(List<Method> list, Class classValue) {

        try {
            Object obj = classValue.getDeclaredConstructor().newInstance();
            list.get(0).invoke(obj);
            for (int i = 1; i < list.size(); i++) {
                list.get(i).invoke(obj);
            }
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

    }

    private static void creatingMethodMass(Method[] methods, List<Method> listCurrentAnnotation,
                                           List<Method> listTestAnnotation) {
        Method method = null;
        for (Method m : methods) {
            BeforeSuite a = m.getAnnotation(BeforeSuite.class);
            Test b = m.getAnnotation(Test.class);
            AfterSuite c = m.getAnnotation(AfterSuite.class);

            if (a != null) {
                valBefore++;
                if (valBefore > 1) throw new RuntimeException("Before suite more then need..");
                else {
                    listCurrentAnnotation.add(0, m);
                }
            }

            if (b != null) {
                listTestAnnotation.add(m);
            }

            if (c != null) {
                valAfter++;
                if (valAfter > 1) throw new RuntimeException("After suite more then need..");
                else {
                    method = m;
                }
            }
        }
        if (listTestAnnotation.isEmpty()) {
            throw new RuntimeException("Class has no any test methods");
        }
        if (!listCurrentAnnotation.isEmpty()) {
            listCurrentAnnotation.addAll(1, sortListAnnotations(listTestAnnotation));
        } else {
            listCurrentAnnotation.addAll(sortListAnnotations(listTestAnnotation));
        }
        if (method != null) {
            listCurrentAnnotation.add(method);
        }
    }

    private static List<Method> sortListAnnotations(List<Method> listTestAnnotation) {
        Collections.sort(listTestAnnotation, (o1, o2) -> {

            Test val1 = o1.getAnnotation(Test.class);
            Test val2 = o2.getAnnotation(Test.class);
            int intVal1 = val1.order();
            int intVal2 = val2.order();
            return intVal1 - intVal2;
        });
        return listTestAnnotation;
    }
}