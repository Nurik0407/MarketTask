package enums;

public enum Product {
    BANANA("BANANA",20),
    APPLE("Apple",20,0.2),
    MILK("Milk",70,0.1),
    BOOK("Book",250,0.2),
    KOKO_KOLA("Kola",60),
    WATER("Water",30),
     FANTA("Fanta",55),
    CAR_TOY("Car",500,0.4);

    private String name;
    private double price;
    private double discount;

    Product(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Product(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
