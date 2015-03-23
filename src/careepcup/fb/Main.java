package careepcup.fb;

public class Main {

    // http://www.careercup.com/question?id=4911380140392448
    public static void main(String[] args) {
        String equation = "1*5*4+8*9+16";
        int result = compute(equation);
        System.out.println(result);

        // An equation with +, -, /, *
        String anotherEquation = "1*5*4+8*9+16/8-9"; // 83
        double another = computeAnother(anotherEquation);
        System.out.println(another);
    }

    static double computeAnother(String equation) {
        double result = 0.0;
        String noMinus = equation.replace("-", "+-");
        String[] byPluses = noMinus.split("\\+");

        for (String multipl : byPluses) {
            String[] byMultipl = multipl.split("\\*");
            double multiplResult = 1.0;
            for (String operand : byMultipl) {
                if (operand.contains("/")) {
                    String[] division = operand.split("\\/");
                    double divident = Double.parseDouble(division[0]);
                    for (int i = 1; i < division.length; i++) {
                        divident /= Double.parseDouble(division[i]);
                    }
                    multiplResult *= divident;
                } else {
                    multiplResult *= Double.parseDouble(operand);
                }
            }
            result += multiplResult;
        }

        return result;
    }

    static int compute(String equation) {
        int result = 0;
        String[] byPluses = equation.split("\\+");
        for (String multipl : byPluses) {
            String[] byMultipl = multipl.split("\\*");
            int multiplResult = 1;
            for (String operand : byMultipl) {
                multiplResult *= Integer.parseInt(operand);
            }
            result += multiplResult;
        }
        return result;
    }

}
