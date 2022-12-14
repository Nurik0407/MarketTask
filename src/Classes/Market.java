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
                                }
                                if (yesOrNo.toLowerCase().equals("no")) {
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

    public String removeMarket(ArrayList<Market> markets) {

        System.out.println("Enter market name : ");
        String marketName = new Scanner(System.in).nextLine();

        for (Market market : markets) {
            if (market.getName().equals(marketName)) {

                System.out.println("Delete market? (yes/no : ");
                String yesOrNo = new Scanner(System.in).nextLine();

                if (yesOrNo.toLowerCase().equals("yes")) {
                    markets.remove(market);
                    return "Market successfully deleted";
                }
                if (yesOrNo.toLowerCase().equals("no")) {
                    break;
                }
            }
        }
        return "Market not deleted!";
    }

    public String changeMarket(ArrayList<Market> markets) {
        System.out.println("Market name : ");
        String nameMarket = new Scanner(System.in).nextLine();
        for (Market market : markets) {
            if (market.getName().equals(nameMarket)) {
                while (true) {
                    System.out.println("What do you want to change");
                    System.out.println("1 = Name market");
                    System.out.println("2 = Products market");
                    System.out.println("3 = Account market");
                    System.out.println("4 = Exit");

                    int i = new Scanner(System.in).nextInt();
                    if (i == 4) break;
                    switch (i) {
                        case 1 -> {
                            System.out.println("Enter new name market : ");
                            String name = new Scanner(System.in).nextLine();

                            System.out.println("Save?");
                            String yesOrNo = new Scanner(System.in).nextLine();
                            if (yesOrNo.toLowerCase().equals("yes")) {
                                market.setName(name);
                                return "New name market successfully saved";
                            }
                            if (yesOrNo.toLowerCase().equals("no")) {
                                return "Not saved!";
                            }
                        }
                        case 2 -> {

                            while (true) {
                                System.out.println("1 = Deleted product");
                                System.out.println("2 = Add product");
                                int num = new Scanner(System.in).nextInt();

                                switch (num) {
                                    case 1 -> {
                                        System.out.println(market.getProducts());
                                        System.out.println("\nThe product's name : ");
                                        String name = new Scanner(System.in).nextLine();

                                        boolean nameIsTrue = false;
                                        for (Product product : market.getProducts()) {
                                            nameIsTrue = true;
                                            if (product.getName().toUpperCase().equals(name.toUpperCase())) {
                                                market.getProducts().remove(product);
                                                return "Product successfully deleted";
                                            }
                                        }
                                        if (!nameIsTrue) {
                                            return "Product unsuccessfully deleted!";
                                        }
                                    }
                                    case 2 -> {
                                        System.out.println(market.getProducts());
                                        System.out.println("\nName product : ");
                                        String name = new Scanner(System.in).nextLine();
                                        for (Product product : market.getProducts()) {
                                            if (product.getName().toLowerCase().equals(name.toLowerCase())) {
                                                System.out.println("New name product : ");
                                                String newName = new Scanner(System.in).nextLine();
                                                for (Product value : Product.values()) {
                                                    if (newName.toLowerCase().equals(value.getName().toLowerCase())) {
                                                        System.out.println("Enter price product : ");
                                                        double price = new Scanner(System.in).nextDouble();
                                                        if (price == 0) return "Not exist prise";
                                                        System.out.println("Enter discount : ");
                                                        double discount = new Scanner(System.in).nextDouble();
                                                        System.out.println("Saved? ");
                                                        String yesOrNo = new Scanner(System.in).nextLine();
                                                        if (yesOrNo.toLowerCase().equals("yes")) {
                                                            product.setName(newName.toUpperCase());
                                                            product.setPrice(price);
                                                            product.setDiscount(discount);
                                                            return "Product successfully saved";
                                                        }
                                                        if (yesOrNo.toLowerCase().equals("no")) {
                                                            return "Product unsuccessfully saved";
                                                        }

                                                    }
                                                }

                                            }
                                        }


                                    }
                                }

                            }
                        }
                        case 3 -> {
                            System.out.println("enter account market : ");
                            long acc = new Scanner(System.in).nextLong();
                            market.setMargetAccount(acc);
                        }
                    }
                }
            }
        }

return null;
    }


}
