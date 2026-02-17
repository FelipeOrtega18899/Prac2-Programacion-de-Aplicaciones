public class calcsinexepcion {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Usage: java Calculator operand1 operator operand2");
            System.exit(1);
        }

        if (!esNumero(args[0])) {
            System.out.println("Entrada incorrecta: " + args[0]);
            return;
        }

        if (!esNumero(args[2])) {
            System.out.println("Entrada incorrecta: " + args[2]);
            return;
        }

        int operand1 = Integer.parseInt(args[0]);
        int operand2 = Integer.parseInt(args[2]);
        int result = 0;

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
                System.out.println("Operador no válido");
                return;
        }

        System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);
    }

    private static boolean esNumero(String s) {
        if (s == null || s.isEmpty()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}