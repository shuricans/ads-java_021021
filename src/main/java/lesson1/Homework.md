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
a)  Итоговая сложность O (n(logn)^2)
- Внешний цикл: O(n), n итераций т.е. 10000.
- Внутренний цикл: O(logn)
  - j всегда является степенью двойки.  
    Начинаем с j = 1 (2^0) заканчиваем j = 8192 (2^13).  
    Итого имеем 14 итераций внутреннего цикла + 1 внешнего.
    10000 * 15 = 150000 итераций.
```
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i++) { // O(n)
            for (int j = 1; j < n; j *= 2) { // O(logn)^2
                arrayList.add(i * j);
            }
        }
```
b) O(n^2) 25млн

```
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            for (int j = i; j < n; j++) {
                arrayList.add(i * j);
            }
        }
```

с) O(nlogn), 10001

```
        int n = 10000;
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < n; i ++) { //O(logn)
            for (int j = 0; j < n; j++) {//O(n/2) > O(n)
                arrayList.add(i * j);
				n--;
            }
        }
```

d) O(n), 10000
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