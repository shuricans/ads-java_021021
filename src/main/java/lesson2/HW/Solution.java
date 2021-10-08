package lesson2.HW;

import lesson2.sort.PigeonholeSort;

import java.util.Arrays;
import java.util.List;

public class Solution {


    public static void main(String[] args) {
        Laptop[] laptops = Utils.getArray(15);
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }

        sortInsert(laptops);
        System.out.println();

        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }

    }

    public static void sortInsert(Laptop[] laptops) {
        int in, out;
        for (out = 1; out < laptops.length; out++) {
            Laptop temp = laptops[out];
            in = out;
            while (in > 0 && laptops[in - 1].getPrice() >= temp.getPrice()) {
                // Если цена строго равна
                if (laptops[in - 1].getPrice() == temp.getPrice()) {

                    // 2-я ступень ПАМЯТЬ:
                    // Если памяти меньше - менять не надо
                    if (laptops[in - 1].getRam() < temp.getRam()) {
                        break;
                    }

                    // Если память строго равна
                    if (laptops[in - 1].getRam() == temp.getRam()) {
                        // Сравниваем бренды
                        if (Utils.BRANDS_MAP.get(laptops[in - 1].getBrand()) < Utils.BRANDS_MAP.get(temp.getBrand())) {
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
