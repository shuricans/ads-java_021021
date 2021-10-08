package lesson2.HW;

public class Laptop {
    private int price;
    private int ram;
    private String brand;

    public Laptop(int price, int ram, String brand) {
        this.price = price;
        this.ram = ram;
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public String getBrand() {
        return brand;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "price=" + price +
                ", ram=" + ram +
                ", brand='" + brand + '\'' +
                '}';
    }
}
