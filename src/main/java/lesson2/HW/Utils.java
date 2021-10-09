package lesson2.HW;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {

    private static final int MIN_PRICE = 500;
    private static final int MAX_PRICE = 2000;
    private static final int STEP_PRICE = 50;
    private static final int[] price;

    private static final int MIN_RAM = 4;
    private static final int MAX_RAM = 24;
    private static final int STEP_RAM = 4;
    private static final int[] ram;

    protected static final String[] BRANDS = {"Lenuvo", "Asos", "MacNote", "Eser", "Xamiou"};

    protected static final Map<String, Integer> BRANDS_MAP = new HashMap<>();

    static {
        price = new int[(MAX_PRICE - MIN_PRICE) / STEP_PRICE + 1];
        price[0] = MIN_PRICE;
        for (int i = 1; i < price.length; i++) {
            price[i] = price[i - 1] + STEP_PRICE;
        }

        ram = new int[(MAX_RAM - MIN_RAM) / STEP_RAM + 1];
        ram[0] = MIN_RAM;
        for (int i = 1; i < ram.length; i++) {
            ram[i] = ram[i - 1] + STEP_RAM;
        }

        for (int i = 0; i < BRANDS.length; i++) {
            BRANDS_MAP.put(BRANDS[i], i);
        }
    }

    public static Laptop[] getArray(int amount) {
        Laptop[] laptops = new Laptop[amount];

        for (int i = 0; i < amount; i++) {
            laptops[i] = new Laptop(
                    price[ThreadLocalRandom.current().nextInt(price.length)],
                    ram[ThreadLocalRandom.current().nextInt(ram.length)],
                    BRANDS[ThreadLocalRandom.current().nextInt(BRANDS.length)]
            );
        }

        return laptops;
    }

    /**
     * Sorting the {@code laptops} array in specific order:
     * 1 - By price, asc
     * 2 - By RAM, asc
     * 3 - By brands: "Lenuvo" > "Asos" > "MacNote" > "Eser" > "Xamiou"
     * Based on insertion sort
     * Complexity O(n^2)... :(
     *
     * @param laptops - just array of Laptops objects
     */
    public static void sortInsert(Laptop[] laptops) {
        int in, out;
        for (out = 1; out < laptops.length; out++) {
            Laptop temp = laptops[out];
            in = out;
            // first level - prices compare:
            while (in > 0 && laptops[in - 1].getPrice() >= temp.getPrice()) {
                // if prices are equal... go to the next level
                if (laptops[in - 1].getPrice() == temp.getPrice()) {

                    // second level - RAM compare:
                    // if less - no need to change
                    if (laptops[in - 1].getRam() < temp.getRam()) {
                        break;
                    }

                    // if RAM's equal... go to the next level
                    if (laptops[in - 1].getRam() == temp.getRam()) {
                        // third level - brands names compare:
                        // if less - no need to change
                        if (BRANDS_MAP.get(laptops[in - 1].getBrand()) < BRANDS_MAP.get(temp.getBrand())) {
                            break;
                        }
                    }

                }
                laptops[in] = laptops[in - 1];
                --in;
            }
            laptops[in] = temp;
        }
    }
}
