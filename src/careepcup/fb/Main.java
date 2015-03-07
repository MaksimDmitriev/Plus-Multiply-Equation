package careepcup.fb;


public class Main {
    
    // http://www.careercup.com/question?id=4911380140392448
    public static void main(String[] args) {
        String equation = "1*5*4+8*9+16";
        int result = compute(equation);
        System.out.println(result);
    }
    
    static int compute(String equation) {
        int result = 0;
        String []byPluses = equation.split("\\+");
        for (String multipl : byPluses) {
            String []byMultipl = multipl.split("\\*");
            int multiplResult = 1;
            for (String operand : byMultipl) {
                multiplResult *= Integer.parseInt(operand);
            }
            result += multiplResult;
        }
        return result;
    }

}
