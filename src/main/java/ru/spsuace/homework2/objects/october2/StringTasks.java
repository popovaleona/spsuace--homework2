package ru.spsuace.homework2.objects.october2;

public class StringTasks {

    /**
     * Убрать все лишние символы из строки и вернуть получившееся число.
     * Разрешенные символы: цифры, '-', '.', 'e'
     * Если '.' и 'e' больше чем 1, возвращаем null
     * Правила на '-' является валидность числа. --3 не валидно. -3e-1 валдино
     * Любой класс-обертка над примитивами наследуется от Number
     * Можно использовать функции Double.valueOf() и другие такие же.
     *
     * Работайте со строкой, НЕ надо ее переводить в массив байт (это можно использовать только для цикла)
     * У класса Character есть полезные методы, например Character.isDigit()
     */
    public static Number simpleValueOf(String str) {
        //Проверка
        if (str == null || str.isEmpty()) {
            return null;
        }
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '-' || Character.isDigit(str.charAt(i)) || str.charAt(i) == 'e' || str.charAt(i) == '.') {
                result += str.charAt(i);
            }
        }
        if (result.matches("-?[0-9]+")) {
            if (Long.valueOf(result) > Integer.MAX_VALUE || Long.valueOf(result) < Integer.MIN_VALUE) {
                return Long.valueOf(result);
            }
            return Integer.valueOf(result);
        }
        if (result.matches("-?[0-9]+e-?[0-9]+") || result.matches("-?[0-9]+\\.[0-9]+e-?[0-9]+") || result.matches("-?[0-9]+\\.[0-9]")) {
            return Double.valueOf(result);
        }
        return null;
    }


    /**
     * Дополнительно задание
     * Тоже самое, что и выше, но нельзя пользоваться функциями valueOf() и new Integer и тд
     */
    public static Number valueOf(String str) {
        return null;
    }
}
