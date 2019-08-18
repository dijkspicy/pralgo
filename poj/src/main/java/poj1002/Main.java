package poj1002;

import java.util.*;

/**
 * com.dijkspicy.pralgo.poj
 *
 * @author t00321127
 * @date 2018/3/31
 */
public class Main {
    private static final Map<Character, Integer> ENTER_NUMBERS = new HashMap<Character, Integer>();

    static {
        ENTER_NUMBERS.put('A', 2);
        ENTER_NUMBERS.put('B', 2);
        ENTER_NUMBERS.put('C', 2);

        ENTER_NUMBERS.put('D', 3);
        ENTER_NUMBERS.put('E', 3);
        ENTER_NUMBERS.put('F', 3);

        ENTER_NUMBERS.put('G', 4);
        ENTER_NUMBERS.put('H', 4);
        ENTER_NUMBERS.put('I', 4);

        ENTER_NUMBERS.put('J', 5);
        ENTER_NUMBERS.put('K', 5);
        ENTER_NUMBERS.put('L', 5);

        ENTER_NUMBERS.put('M', 6);
        ENTER_NUMBERS.put('N', 6);
        ENTER_NUMBERS.put('O', 6);

        ENTER_NUMBERS.put('P', 7);
        ENTER_NUMBERS.put('R', 7);
        ENTER_NUMBERS.put('S', 7);

        ENTER_NUMBERS.put('T', 8);
        ENTER_NUMBERS.put('U', 8);
        ENTER_NUMBERS.put('V', 8);

        ENTER_NUMBERS.put('W', 9);
        ENTER_NUMBERS.put('X', 9);
        ENTER_NUMBERS.put('Y', 9);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String enter = scanner.nextLine();
        int count = Integer.parseInt(enter);
        List<String> list = new LinkedList<String>();
        while (count-- > 0) {
            list.add(scanner.nextLine());
        }

        Map<String, Integer> numbers = new TreeMap<String, Integer>();
        for (String it : list) {
            it = it.replace("-", "");
            if (it.length() != 7) {
                throw new RuntimeException("invalid number");
            }
            StandardNumber number = new StandardNumber();
            for (int i = 0; i < it.length(); i++) {
                char ch = it.charAt(i);
                if (Character.isLetter(ch) && ch != 'Q' && ch != 'Z') {
                    number.add(i, ENTER_NUMBERS.get(ch));
                } else if (Character.isDigit(ch)) {
                    number.add(i, Character.digit(ch, 10));
                } else {
                    throw new RuntimeException("invalid number");
                }
            }

            if (numbers.containsKey(number.toString())) {
                numbers.put(number.toString(), numbers.get(number.toString()) + 1);
            } else {
                numbers.put(number.toString(), 1);
            }
        }

        for (Map.Entry<String, Integer> entry : numbers.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    private static class StandardNumber {
        private List<Integer> numbers = new ArrayList<Integer>(7);

        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            StandardNumber that = (StandardNumber) o;

            if (!((this.numbers == that.numbers) || (this.numbers != null && this.numbers.equals(that.numbers)))) {
                return false;
            }

            for (int i = 0; i < this.numbers.size(); i++) {
                Integer a = this.numbers.get(i);
                Integer b = that.numbers.get(i);
                if (!(a.equals(b) || a.equals(b))) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.numbers.size(); i++) {
                sb.append(this.numbers.get(i));
                if (i == 2) {
                    sb.append("-");
                }
            }
            return sb.toString();
        }

        void add(int i, Integer integer) {
            this.numbers.add(i, integer);
        }
    }
}
