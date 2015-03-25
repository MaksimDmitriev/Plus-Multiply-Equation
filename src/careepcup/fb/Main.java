package careepcup.fb;

public class Main {

    // http://www.careercup.com/question?id=4911380140392448
    public static void main(String[] args) {
        String equation = "1*5*4+8*9+16";
        int result = compute(equation);
        System.out.println(result);

        String equationWithAllSigns = "-1*5*4/2-8*9-16+1";
        double allSignsResult = computeWithAllOperations(equationWithAllSigns);
        System.out.println(allSignsResult);

    }

    private static int compute(String equation) {
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

    private static double computeWithAllOperations(String input) {
        double result = 0.0;
        /*
         * 1. Split the input string by +
         * 2. Calculate the products and quotients
         * 3. Sum up the results
         */

        // (\\d)- is used instead of - to support strings starting with -
        String parts[] = input.replaceAll("(\\d)-", "$1+-").split("\\+");
        for (String part : parts) {
            result += computeMultAndDivision(part);
        }
        return result;
    }

    private static double computeMultAndDivision(String part) {
        String[] parts = part.split("(?=[/*])|(?<=[/*])");
        double result = Double.parseDouble(parts[0]);
        for (int i = 1; i < parts.length; i += 2) {
            String op = parts[i];
            double val = Double.parseDouble(parts[i + 1]);
            switch (op) {
            case "*":
                result *= val;
                break;
            case "/":
                result /= val;
                break;
            }
        }
        return result;
    }

}
