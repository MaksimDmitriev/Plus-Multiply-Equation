package careepcup.fb;

public class Main {

    // http://www.careercup.com/question?id=4911380140392448
    public static void main(String[] args) {
        // An equation with +, -, /, *
        // "1*5*4+8*9+16/8-9"; An old equation
        String equation = "2+7-21-3*2/1"; // 83
        double result = computeEquation(equation);
        System.out.println(result);
    }

    private static double computeEquation(String input) {
        String[] parts = input.split("(?=[/*])|(?<=[/*])");
        double result = computeSum(parts[0]);

        for (int i = 1; i < parts.length; i += 2) {
            String op = parts[i];
            double val = computeSum(parts[i + 1]);
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
    
    private static double computeSum(String input) {
        // TODO: write a comment
        input = input.replace("-", "+-");
        String []parts = input.split("\\+");
        double result = 0.0;
        for (String operand : parts) {
            result += Double.parseDouble(operand);
        }
        return result;
    }

}
