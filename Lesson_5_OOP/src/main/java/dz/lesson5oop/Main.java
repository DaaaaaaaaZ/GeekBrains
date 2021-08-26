package dz.lesson5oop;

public class Main {
    public static void main(String[] args) {
        Employee [] employees = new Employee[5];

        employees [0] = new Employee("Иванов Иван Сергеевич", "Разнорабочий", "Iviv@mail.ru",
                "89991234567", 15000, 33);
        employees [1] = new Employee("Иванов Николай Петрович", "Оператор ЭВМ", "Ivnik@mail.ru",
                "89991234563", 22000, 42);
        employees [2] = new Employee("Петров Павел Аратович", "Заведующий складом", "Petpav@mail.ru",
                "89991234565", 48000, 29);
        employees [3] = new Employee("Хренова Гадя Петрович", "Уборщица", "Hrega@mail.ru",
                "89991234569", 58000, 65);
        employees [4] = new Employee("Абрамян Сергей Аратович", "Заместитель директора", "abrs@mail.ru",
                "89991234561", 125000, 40);

        printLowerAgeEmployees (employees);
    }

    private static void printLowerAgeEmployees(Employee[] employees) {
        if (employees != null && employees.length > 0) {
            for (int i = 0; i < employees.length; i++) {
                if (employees [i].getAge() > 40) {
                    System.out.println(employees [i]); //Так выводим благодаря переопределённому toString ()
                }
            }
        }
    }
}
