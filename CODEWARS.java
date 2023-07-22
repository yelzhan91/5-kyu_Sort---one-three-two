import java.util.Arrays;
import java.util.stream.Collectors;
public class CODEWARS {
    public static void main(String[] args) {
        CODEWARS codewars = new CODEWARS();
        int[] array1 = {8, 8, 9, 9, 10, 10};
        int[] array2 = {4, 1, 3, 2};
        int[] array3 = {9, 999, 99};
        int[] sortedArray1 = codewars.sort(array1);
        int[] sortedArray2 = codewars.sort(array2);
        int[] sortedArray3 = codewars.sort(array3);
        System.out.println(Arrays.toString(sortedArray1));//{8, 8, 9, 9, 10, 10}
        System.out.println(Arrays.toString(sortedArray2));//{1, 2, 3, 4}
        System.out.println(Arrays.toString(sortedArray3));//{9, 99, 999}
    }
    private static final String[] UNITS = {
            "",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"
    };
    private static final String[] TENS = {
            "",
            "",
            "twenty",
            "thirty",
            "forty",
            "fifty",
            "sixty",
            "seventy",
            "eighty",
            "ninety"
    };
    public static int[] sort(final int array[]) {
        return Arrays.stream(array)
                .mapToObj(value -> new Value(value == 0 ? "zero" : convert(value), value))
                .sorted()
                .collect(Collectors.toList())
                .stream()
                .mapToInt(v -> v.number)
                .toArray();
    }
    private static String convert(final int n) {
        if (n < 20) {
            return UNITS[n];
        }
        if (n < 100) {
            return TENS[n / 10] + ((n % 10 != 0) ? " " : "") + UNITS[n % 10];
        }
        return UNITS[n / 100] + " hundred" + ((n % 100 != 0) ? " and " : "") + convert(n % 100);
    }
    private static class Value implements Comparable<Value> {
        private final String string;
        private final int number;
        public Value(String string, int number) {
            this.string = string;
            this.number = number;
        }
        @Override
        public int compareTo(Value o) {
            return Integer.compare(this.number, o.number);
        }
        /*@Override
        public int compareTo(Value o) {
            return this.string.compareTo(o.string);
        }*/
    }
}