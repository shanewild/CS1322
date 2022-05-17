public class Assignment8 {
    public static String reverse(String s) {
        if (s.length() == 0) {
            return s;
        } else {
            s = reverse(s.substring(1)) + s.charAt(0);
            return s;

        }

    }

    public static String convert(String s) {
        //t=temp
        s = s.replace('v', 't').replace('^', 'v').replace('t', '^');
        ;

        return s;
    }

    public static String paperFold(int end) {
        if (end == 1) {
            return "v";
        } else {

            return convert(reverse(paperFold(end - 1))) + "v" + paperFold(end - 1);

        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            String fold_string = paperFold(i);
            System.out.println("For " + i + " folds we get: " + fold_string + "\n");
        }
    }
}
