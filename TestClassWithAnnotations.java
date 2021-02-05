public class TestClassWithAnnotations {

    @BeforeSuite
    public void beforeTest() {
        System.out.println("beforeTest() with @BeforeSuite");
    }

    @Test(order = 2)
    public void testTwo() {
        System.out.println("Test Two() with @Test");
    }

    @Test(order = 1)
    public void testOne() {
        System.out.println("Test One() with @Test ");
    }

    @Test(order = 1)
    public void testThree() {
        System.out.println("Test Three() with @Test ");
    }

    @AfterSuite
    public void afterTest() {
        System.out.println("AfterTest() with @afterTest ");
    }
}