package practicum;

import java.util.List;

public class Algorithms {

    /**
     *
     * В задачах, в которых заранее не оговорен состав символов в строках,
     * строки могут содержать русские и английские буквы,
     * а также пробелы, знаки препинания, кавычки и скобки.
     *
     * Не использовать при решении регулярные выражения, методы стандартных библиотек
     * java.util.Collections, java.util.Arrays, java.lang.Math, а также методы
     * replace и replaceAll, reverce, equals, indexOf, toLowerCase, toUpperCase
     * split, substring из java.lang.String.
     * Можете использовать циклы, условные операторы,
     * простые типы данных и их обертки.
     *
     * Как изменится сложность ваших решений, если убрать
     * ограничения по использованию функций Java API?
     */

    /**
     * Вычислите максимальное, минимальное и среднее число для списка чисел
     * Верните их сумму
     * Список гарантированно содежит элементы
     */
    public static double maxMinAvr(List<Integer> numbers) {
        int minNumber = numbers.get(0);
        int maxNumber = numbers.get(0);
        double sum = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < minNumber) {
                minNumber = numbers.get(i);
            }
            if (numbers.get(i) > maxNumber) {
                maxNumber = numbers.get(i);
            }
            sum = sum + numbers.get(i);
        }
        return minNumber + maxNumber + sum / numbers.size();
    }


    /**
     * Найдите второе максимальное значение в массиве,
     * если такого нет, то вернуть первое
     * Массив гарантировано содержит элементы
     */
    public static Integer max2(List<Integer> list) {
        Integer firstMax = null;
        Integer secondMax = null;
        Integer buffered = null;
        for (int i = 0; i < list.size(); i++) {
            if (firstMax == null || list.get(i) > firstMax) {
                buffered = firstMax;
                firstMax = list.get(i);
            }
            if (secondMax == null || buffered > secondMax) {
                secondMax = buffered;
            }
        }
        if (secondMax != null) {
            return secondMax;
        } else return firstMax;
    }

    /**
     * Удалите число из массива.
     * Верните массив не содержащий этого элемента,
     * но и не содержащий "пропусков" на месте удаленных элементов
     * Например, если из массива [0, 6, 0 ,5, 0] нужно удалить элемент 0,
     * то возвращаться должен массив содержащий два элемента [6, 5]
     */
    public static int[] removeElementFromArray(int[] numbers, int value) {
        int arraySize = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != value) {
                arraySize++;
            }
        }
        int[] newArray = new int[arraySize];
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != value) {
                newArray[index] = numbers[i];
                index++;
            }
        }
        return newArray;
    }


    /**
     * Удалите все гласные из строки.
     * Например, "мАма Мыла раму" -> "мм Мл рм"
     */
    public static String removeVowels(String str) {
        String newString = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != 'а'
                    && str.charAt(i) != 'А'
                    && str.charAt(i) != 'е'
                    && str.charAt(i) != 'Е'
                    && str.charAt(i) != 'ё'
                    && str.charAt(i) != 'Ё'
                    && str.charAt(i) != 'и'
                    && str.charAt(i) != 'И'
                    && str.charAt(i) != 'о'
                    && str.charAt(i) != 'О'
                    && str.charAt(i) != 'э'
                    && str.charAt(i) != 'Э'
                    && str.charAt(i) != 'Ю'
                    && str.charAt(i) != 'ю'
                    && str.charAt(i) != 'Я'
                    && str.charAt(i) != 'я'
                    && str.charAt(i) != 'Ы'
                    && str.charAt(i) != 'ы'
                    && str.charAt(i) != 'у'
                    && str.charAt(i) != 'У'
                    && str.charAt(i) != 'e'
                    && str.charAt(i) != 'E'
                    && str.charAt(i) != 'U'
                    && str.charAt(i) != 'u'
                    && str.charAt(i) != 'i'
                    && str.charAt(i) != 'I'
                    && str.charAt(i) != 'o'
                    && str.charAt(i) != 'O'
                    && str.charAt(i) != 'a'
                    && str.charAt(i) != 'A'

            ) {
                newString = newString + str.charAt(i);
            }
        }

        return newString;
    }


    /**
     * Убрать повторяющиеся подряд символы в строке
     * например "ммммоолллокко" -> "молоко"
     * (*) - в этой задаче нужно учитывать сочетания
     * повторяющихся букв разного регистра,
     * при этом в выходной строке остается первая буква,
     * например, "мМммооЛллокКОоо" -> "моЛокО",
     */
    public static String removeDublicates(String str) {
        if (str.equals("")) {
            return "";
        }
        Character firstCharValue = str.charAt(0);
        String newString = String.valueOf(firstCharValue);
        for (int i = 1; i < str.length(); i++) {

            if (str.charAt(i) != firstCharValue
                    && str.charAt(i) != Character.toUpperCase(firstCharValue)
                    && str.charAt(i) != Character.toLowerCase(firstCharValue)) {
                firstCharValue = str.charAt(i);
                newString = newString + str.charAt(i);
            } else firstCharValue = str.charAt(i);
        }
        return newString;
    }

    /**
     * Сжать строку, удаляя повторяющиеся символы
     * и указывая количество повторов для каждого символа
     * например "мооолооооккооо" -> "м1о3л1о4к2о2"
     */
    public static String zipStr(String str) {
        if (str.equals("")) {
            return "";
        }
        String newString = "";
        int buffered = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != str.charAt(i - 1)) {
                newString = newString + str.charAt(i - 1) + buffered;
                buffered = 1;
            } else {
                buffered++;
            }
        }
        return newString + str.charAt(str.length() - 1) + buffered;
    }


    /**
     * Выяснить является ли строка палиндромом,
     * то есть  одинаково читается в обоих направлениях.
     * Например, слово "топот" - палиндром, а слово "топор" нет.
     * Строка "А роза упала на лапу Азора" тоже палиндром,
     * а строка "А роза уколола лапу Азора" нет.
     * "A man, a plan, a canal-Panama", тоже палиндром
     * <p>
     * (!) Так как запрещены регулярные выражения
     * и методы преобразования регистра символов из java.lang.String
     * обратите внимание таблицу кодов символов UTF-8
     * (лучше убрать эту подсказку и выдать ее в процессе)
     */
    public static boolean isPalindrom(String str) {

        char[] chars;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 1040 && str.charAt(i) <= 1103)
                    || (str.charAt(i) >= 65 && str.charAt(i) <= 90)
                    || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) {
                count++;
            }
        }
        chars = new char[count];
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 1040 && str.charAt(i) <= 1103)
                    || (str.charAt(i) >= 65 && str.charAt(i) <= 90)
                    || (str.charAt(i) >= 97 && str.charAt(i) <= 122)) {
                chars[index] = Character.toLowerCase(str.charAt(i));
                index++;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[chars.length - i - 1]) {
                return false;
            }
        }
        return true;
    }


    /**
     * Перевернуть все слова в предложении
     * "Кот лакал молоко" -> "тоК лакал околом"
     */
    public static String reverseWordsInSentence(String sentence) {
        String newString = "";
        int count = 0;
        for (int i = 0; i <= sentence.length(); i++) {
            if (i == sentence.length() || (sentence.charAt(i) < 1040 || sentence.charAt(i) > 1103)) {
                String word = "";
                for (int j = 0; j < count; j++) {
                    word = word + sentence.charAt(i - j - 1);
                }
                count = 0;
                if (i == sentence.length()) {
                    newString = newString + word;
                } else
                    newString = newString + word + sentence.charAt(i);
            } else {
                count++;
            }
        }
        return newString;
    }

    /**
     * Отсортируйте символы в массиве,
     * не используйте дополнительные структуры данных.
     * При вводе массива символов {'c', 'a', 'b'},
     * возвращаться должен тот же отсортированный массив {'a', 'b', 'c'}
     */
    public static char[] sortSymbols(char[] symbols) {
        for (int left = 0; left < symbols.length; left++) {
            char value = symbols[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < symbols[i]) {
                    symbols[i + 1] = symbols[i];
                } else {
                    break;
                }
            }
            symbols[i + 1] = value;
        }
        return symbols;
    }


    /**
     * Выясните являются ли две строки анограммами.
     * Строки являются анограммами, если они состоят из одних и тех же букв
     * Например, слова "кот" и "ток" анограммы, а слова "кот" и  "кит" нет.
     */
    public static boolean isAnogramOf(String word, String anogram) {
        if (word.length() != anogram.length()) {
            return false;
        }
        char[] firstWord = sortSymbols(word.toCharArray());
        char[] secondWord = sortSymbols(anogram.toCharArray());
        for (int i = 0; i < firstWord.length; i++) {
            if (firstWord[i] != secondWord[i]) return false;
        }
        return  true;
    }

    /**
     * Выясните, все ли символы в строке встречаются один раз.
     * Если строка содержит повторябщиеся символы,
     * то возвращать false, если не содержит - true
     * Нельзя использовать дополнительные структуры данных.
     * <p>
     * (!) В этой задаче строка может содержать
     * любой символ из таблицы ASCII (127 символов)
     * <p>
     * (!!) Сложность - O(n)
     */

    public static boolean hasUniqueChars(String str) {
    char[] chars = new char[1500];
        for (int i = 0; i < str.length(); i++) {
            if (chars[str.charAt(i)]!=str.charAt(i)){
                chars[str.charAt(i)]=str.charAt(i);
            } else return false;
        }
        return true;
    }

}
