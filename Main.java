import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //#1 task
        String[] arrWords = {
                "tree", "node", "game", "grass", "george"
        };

        FindEquals findEquals = new FindEquals();
        ArrayList<String> list = findEquals.assignMas(arrWords);
        ArrayList<String> clearList = findEquals.clearEquals(list);

        System.out.println(findEquals.assignMas(arrWords));
        System.out.println(clearList);
        System.out.println(findEquals.countEquals(findEquals.assignMas(arrWords), clearList));

        System.out.println("---------------");

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("S", 2222);
        phoneBook.add("S", 2222);
        phoneBook.add("q", 222122);
        phoneBook.add("d", 222312);
        phoneBook.add("x", 2261622);

        System.out.println(phoneBook.get("S"));

    }

}
