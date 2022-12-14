package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class Person {

    private String name;
    private int age;
    private String bank;
    private long bankAccount;

    public Person(String name, int age, String bank, long bankAccount) {
        this.name = name;
        this.age = age;
        this.bank = bank;
        this.bankAccount = bankAccount;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getBankCard() {
        return bankAccount;
    }

    public void setBankCard(long bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public String toString() {
        return "\n=========================\n" +
                "\n    Person" +
                "\nname: " + name +
                "\nage: " + age +
                "\nbank: " + bank +
                "\nbankAccount: " + bankAccount +
                "\n=========================\n";
    }

    /**
     * METHODS
     **/


    public String createPerson(ArrayList<Person> people) {
        try {
            System.out.print("Name person : ");

            String namePerson = new Scanner(System.in).nextLine();

            System.out.print("Enter age : ");
            int agePerson = new Scanner(System.in).nextInt();

            System.out.print("Bank : ");
            String bankPerson = new Scanner(System.in).nextLine();

            System.out.print("Enter bank account : ");
            long bankAccountPerson = new Scanner(System.in).nextLong();
            people.add(new Person(namePerson, agePerson, bankPerson, bankAccountPerson));
            return "Person successfully added";

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Person unsuccessfully added ! ";
    }

    public String getByNamePerson(ArrayList<Person> people) {
        try {
            System.out.println("Person name : ");
            String personName = new Scanner(System.in).nextLine();
            for (Person person : people) {
                if (person.getName().equals(personName)) {
                    System.out.println(person);
                    return "Person successfully founded";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Person not founded!";
    }

    public ArrayList<Person> getAll(ArrayList<Person> people) {
        return people;
    }

}
