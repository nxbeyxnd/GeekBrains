public class Main {

    public static void main(String[] args) {
        //region 1-2 Task
        SwapElements swappableElement= new SwapElements<>();
        //Change only 1st and last element
        swappableElement.putAndSwap("One",
                2,
                "3",
                4,
                "Five5",
                "Six",
                7,
                8D,
                9F
        );
        System.out.println(swappableElement);
        System.out.println(swappableElement.refactorToArrayList(swappableElement.get()));
        //endregion


        Box<Apple> AppleBox = new Box();
        Box<Orange> OrangeBox = new Box();
        Box<Orange> OrangeBox2 = new Box();

        AppleBox.put(
                new Apple(),
                new Apple(),
                new Apple(),
                new Apple(),
                new Apple(),
                new Apple(),
                new Apple(),
                new Apple()
        );

        OrangeBox.put(
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange()

        );OrangeBox2.put(
                new Orange(),
                new Orange()
        );

//        OrangeBox2.changeAnyBox(OrangeBox);

        System.out.println(AppleBox.showWeight());
        System.out.println(OrangeBox.showWeight());
        System.out.println(OrangeBox2.showWeight());

        System.out.println(OrangeBox2.compare(OrangeBox));

    }
}