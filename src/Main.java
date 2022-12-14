import Classes.Market;
import Classes.Person;
import enums.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Person person = new Person();
    static Market market = new Market();

    public static void main(String[] args) throws Exception {

        ArrayList<Person> people = new ArrayList<>();
        people.add(new Person("Diaz", 18, "Kyrgyzstan", 1000));
        people.add(new Person("Dastan", 19, "Optima", 3000));

        ArrayList<Market> markets = new ArrayList<>();
        markets.add(new Market("Globus", new ArrayList<>(Arrays.asList(Product.APPLE, Product.BANANA, Product.BOOK)), 3000));
        markets.add(new Market("Frunze", new ArrayList<>(Arrays.asList(Product.FANTA, Product.MILK, Product.WATER, Product.CAR_TOY, Product.BANANA)), 1000));

        while (true) {
            System.out.println("1 = Create person : ");
            System.out.println("2 = Find by name person");
            System.out.println("3 = Get all person");
            System.out.println("4 = Purchase");
            System.out.println("5 = Find by name product");
            System.out.println("6 = Create market");
            System.out.println("7 = Get all market");

            int number = new Scanner(System.in).nextInt();

            switch (number) {
                case 1 -> System.out.println(person.createPerson(people));
                case 2 -> System.out.println(person.getByNamePerson(people));
                case 3 -> System.out.println(person.getAll(people));
                case 4 -> System.out.println(market.purchase(people, markets));
                case 5 -> System.out.println(market.getByNameProduct(markets));
                case 6 -> System.out.println(market.createMarket(markets));
                case 7 -> System.out.println(market.getAllMarket(markets));

            }
        }
    }
}