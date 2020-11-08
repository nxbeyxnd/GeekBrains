public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee();

        employee.fio = "Ivanov Ivan";
        employee.post = "Engineer";
        employee.email = "Ivan@mail.ru";
        employee.number = "892312312";
        employee.salary = 30000;
        employee.age = 30;
        employee.showEmployeeFields();
        System.out.println("=======Next task=======");



        Employee[] perArray = new Employee[5];
        perArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        perArray[1] = new Employee("Kirillov Ivan", "Director", "Kitill@mailbox.com", "89231234", 50000, 20);
        perArray[2] = new Employee("Olewkin Ivan", "Reseller", "StockX@mailbox.com", "892321422", 20000, 50);
        perArray[3] = new Employee("Cofix Ivan", "Engineer", "Focix@mailbox.com", "892374574", 40000, 60);
        perArray[4] = new Employee("Jensh Ivan", "Guest", "Noxis@mailbox.com", "892386858", 5000, 50);

        for (int i = 0; i < perArray.length; i++) {
            if (perArray[i].age > 40) employee = new Employee(perArray[i]);
        }


    }

}