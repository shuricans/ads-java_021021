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
//                    price[0],
                    price[ThreadLocalRandom.current().nextInt(price.length)],
                    ram[ThreadLocalRandom.current().nextInt(ram.length)],
                    BRANDS[ThreadLocalRandom.current().nextInt(BRANDS.length)]
            );
        }

        return laptops;
    }
}
