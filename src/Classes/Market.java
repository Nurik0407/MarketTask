package Classes;

import enums.Product;

import java.util.*;

public class Market {
    private String name;
    private ArrayList<Product> products;
    private long margetAccount;


    public Market(String name, ArrayList<Product> products, long margetAccount) {
        this.name = name;
        this.products = products;
        this.margetAccount = margetAccount;
    }

    public Market() {
    }

    public long getMargetAccount() {
        return margetAccount;
    }

    public void setMargetAccount(long margetAccount) {
        this.margetAccount = margetAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "\n======================" +
                "\n     Market" +
                "\nname : " + name +
                "\nproducts=" + products +
                "\nmarketAccount=" + margetAccount +
                "\n======================";
    }

    /**
     * ===================METHODS==================
     **/


    public String purchase(ArrayList<Person> people, ArrayList<Market> marketDataBase) {
        try {
            ArrayList<Product> products1 = new ArrayList<>();
            products1.clear();

            Map<String, Double> productDiscount = new LinkedHashMap<>();
            productDiscount.clear();

            System.out.println("Your name : ");
            String yourName = new Scanner(System.in).nextLine();

            if (yourName.isEmpty()) return "Field cannot be empty";

            double totalPrice = 0;
            double priceAll = 0;

            for (Person person : people) {
                if (person.getName().toLowerCase().equals(yourName.toLowerCase())) {

                    for (Market market : marketDataBase) {
                        System.out.println(market.getName() + " ");
                    }

                    System.out.println("\nSelect market : ");


                    String nameMarket = new Scanner(System.in).nextLine();

                    for (Market market : marketDataBase) {
                        if (market.getName().toLowerCase().equals(nameMarket.toLowerCase())) {

                            System.out.println("\n" + market.getName() + "products : " + market.getProducts() + "\n");

                            while (true) {
                                System.out.println("Will you buy something? (yes/no) : ");
                                String yesOrNo = new Scanner(System.in).nextLine();

                                if (yesOrNo.equals("yes")) {

                                    System.out.println("What will you buy : ");
                                    System.out.println(market.getProducts());
                                    String nameProduct = new Scanner(System.in).nextLine();

                                    for (Product product : market.getProducts()) {
                                        if (product.getName().toUpperCase().equals(nameProduct.toUpperCase())) {

                                            products1.add(product);
                                            priceAll += product.getPrice();


                                            if (product.getDiscount() == 0) {
                                                totalPrice += product.getPrice();
                                            } else {
                                                totalPrice += product.getPrice() - product.getPrice() * product.getDiscount();
                                            }

                                            if (product.getDiscount() != 0) {
                                                productDiscount.put(product.getName(), product.getDiscount());
                                            }
                                        }
                                    }
                                } else {
                                    person.setBankCard((long) (person.getBankCard() - totalPrice));
                                    market.setMargetAccount((long) (market.getMargetAccount() + totalPrice));
                                    return "=====================================" +
                                            "\nBayer : " + person.getName() +
                                            "\nMarket : " + market.getName() +
                                            "\nProducts : " + products1 +
                                            "\nTotal cost of goods : " + priceAll +
                                            "\nDiscount : " + productDiscount +
                                            "\nTotal price after discount : " + totalPrice +
                                            "\n=====================================" +
                                            "\nThank you for your purchase\n";

                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getByNameProduct(ArrayList<Market> markets) throws Exception {

        try {
            System.out.println("Product : ");
            String name = new Scanner(System.in).nextLine();
            boolean nameProduct = false;
            for (Market market : markets) {
                for (Product product : market.getProducts()) {
                    if (product.getName().toLowerCase().equals(name.toLowerCase())) {
                        nameProduct = true;
                        System.out.println("\n====================" +
                                "\nMarket : " + market.getName() +
                                "\nProduct : " + product.getName() +
                                "\nPrice : " + product.getPrice() +
                                "\nDiscount : " + product.getDiscount() +
                                "\n====================");
                    }
                }
            }
            if (!nameProduct) {
                return "Product not founded!";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Product founded";
    }

    public ArrayList<Market> getAllMarket(ArrayList<Market> markets) {
        return markets;
    }

    public String createMarket(ArrayList<Market> markets) {

        try {
            ArrayList<Product> productArrayList = new ArrayList<>();
            System.out.println("Market name : ");
            String marketName = new Scanner(System.in).nextLine();


            while (true) {
                System.out.println("Add  products? (yes/no)");
                String yesOrNo = new Scanner(System.in).nextLine();

                if (yesOrNo.toLowerCase().equals("yes")) {
                    System.out.println("Product name : ");
                    String productName = new Scanner(System.in).nextLine();
                    productArrayList.add(Product.valueOf(productName.toUpperCase()));

                } else {
                    System.out.println("Enter market account : ");
                    long marketAcc = new Scanner(System.in).nextLong();
                    markets.add(new Market(marketName, new ArrayList<>(productArrayList), marketAcc));
                    return "Market successfully created";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Market unsuccessfully created!";
    }
}
