public class CalculatorWithException {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            System.exit(1);
        }

        int result = 0;

        try {
            int operand1 = Integer.parseInt(args[0]);
            int operand2 = Integer.parseInt(args[2]);

            switch (args[1].charAt(0)) {
                case '+':
                    result = operand1 + operand2;
                    break;
                case '-':
                    result = operand1 - operand2;
                    break;
                case '*':
                    result = operand1 * operand2;
                    break;
                case '/':
                    result = operand1 / operand2;
                    break;
                default:
                    System.out.println("Error: Operador no válido.");
                    System.exit(1);
            }

            System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);

        } catch (NumberFormatException e) {

            if (!esNumero(args[0])) {
                System.out.println("Error: El primer operando no es numérico -> " + args[0]);
            }

            if (!esNumero(args[2])) {
                System.out.println("Error: El segundo operando no es numérico -> " + args[2]);
            }

            System.exit(1);
        }
    }

    private static boolean esNumero(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}