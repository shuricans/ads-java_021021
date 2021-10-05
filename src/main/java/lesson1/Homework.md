**По вопросам проверки и переноса обращаться к Игорю tg: @inchestnov**
### 1. Прочитать в книге "Грокаем алгоритмы" или в предложенных материалах про алгоритмы и О-большое.
###2. Определить сложность следующих алгоритмов:
-. Поиск элемента массива с известным индексом - O(1)

-.Дублирование одномерного массива через foreach - O(n)

-. Удаление элемента массива с известным индексом без сдвига - O(1)

-. Удаление элемента массива с неизвестным индексом без сдвига - O(n)

-. Удаление элемента массива с неизвестным индексом со сдвигом - O(n)
.
###3. Определить сложность следующих алгоритмов. Сколько произойдет итераций?
a) O(nlogn) Кол-во итераций при (n = 10000) равно 10000 * 14 = 140000
- Внешний цикл: O(n) = 10000
- Внутренний цикл: O(logn) = [2^0,2^1....2^13] = 14
```
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) { // O(n)
            for (int j = 1; j < n; j *= 2) { // O(logn)
                arrayList.add(i * j);
            }
        }
```
b) O(n^2)  Кол-во итераций 25005000 (см. ниже)
- Внешний цикл: O(n/2) => O(n)
- Внутренний цикл: O(n)
- Кол-во итераций
  - Кол-во итераций внутреннего цикла всегда равно n, но...
  - Внешний цикл "генерирует" арифметическую прогрессию с разностью 2
  - Сумма первых n членов арифметической прогрессии выражается формулой S = (a + an)*n/2, в нашем случае a = 2.
  - Кол-во чисел в этой прогрессии равно k = n/2 = 10000/2 = 5000
  - S = (2 + 2k) * k/2 = (2 + 2 * 5000) * 5000/2 = 25005000

```
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i += 2) { // O(n/2) > O(n)
            for (int j = i; j < n; j++) { // O(n)
                arrayList.add(i * j);
            }
        }
```

с) O(n), 9991

```
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i ++) { // O(n)
            for (int j = 0; j < n; j++) { // O(n/2) > O(n)
                arrayList.add(i * j);
				n--;
            }
        }
```

d) O(n), кол-во итераций равно n
```
		
		factorial(BigInteger.valueOf(10000))
	
    public static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return n;
        }
        return n.multiply(factorial(n.subtract(BigInteger.valueOf(1))));
    }
```

e) O(2^n)
```
	
	fib(BigInteger.valueOf(50));

    public static BigInteger fib(BigInteger n) {
        if (n.equals(BigInteger.ONE)) {
            return BigInteger.ZERO;
        }
        if (n.equals(BigInteger.TWO)) {
            return BigInteger.ONE;
        }
        return fib(n.subtract(BigInteger.ONE)).add(fib(n.subtract(BigInteger.TWO)));
    }
```