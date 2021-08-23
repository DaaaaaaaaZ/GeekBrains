package dz.lesson5oop;

public class Employee {
    private String fio = "";
    private String position = "";
    private String email = "";
    private String phone = "";
    private int salary = 0;
    private int age = 0;

    public Employee(String fio, String position, String email, String phone, int salary, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    //В ДЗ вроде не было требований к методу вывода информации о сотруднике
    @Override
    public String toString() {
        return this.fio + ", " + this.position + ", " + this.email + ", " + this.phone + ", " +
                this.salary + ", " + age;
    }
}
