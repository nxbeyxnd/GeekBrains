public class Employee {
    public String fio;
    public String post;
    public String email;
    public String number;
    public int salary;
    public int age;


    public Employee(String fio, String post, String email, String number, int salary, int age) {
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.number = number;
        this.salary = salary;
        this.age = age;

        showEmployeeFields();
    }

    public Employee(Employee employee) {
        showEmployeeFields();
    }

    public Employee() {

    }

    //region GET SET
    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    //endregion

    public void showEmployeeFields() {
        if (age > 40)
        System.out.println(String.format("FIO: %s, POST: %s, EMAIL: %s, NUMBER: %s, SALARY: %s, AGE: %s",
                this.fio, this.post, this.email, this.number, this.salary, this.age));
    }
}
