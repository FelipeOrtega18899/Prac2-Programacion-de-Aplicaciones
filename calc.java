import java.util.InputMismatchException;
import java.util.Scanner;  // Para capturar errores de entrada

public class calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;  // Variable para controlar el bucle
        
        System.out.println("=== CALCULADORA BÁSICA ===\n");
        
        // Bucle principal - se repite hasta que el usuario quiera salir
        while (continuar) {
            double num1 = 0, num2 = 0;  // Variables para los números
            String operacion = "";
            boolean entradaValida = false;  // Bandera para validar entrada
            
            // PASO 1: Pedir primer número con try-catch
            while (!entradaValida) {
                try {
                    System.out.print("Ingresa el primer número: ");
                    num1 = scanner.nextDouble();  // Lee un número decimal
                    entradaValida = true;  // Si llegó aquí, la entrada fue válida
                    
                } catch (InputMismatchException e) {  // Captura error si escriben letras
                    System.out.println("❌ Error: Debes ingresar un número válido.");
                    scanner.next();  // Limpia el buffer (elimina la basura que quedó)
                }
            }
            
            // PASO 2: Pedir la operación
            entradaValida = false;  // Resetea la bandera
            while (!entradaValida) {
                System.out.print("Ingresa la operación (+, -, *, /): ");
                operacion = scanner.next();  // Lee un texto
                
                // Valida que sea una operación válida
                if (operacion.equals("+") || operacion.equals("-") || 
                    operacion.equals("*") || operacion.equals("/")) {
                    entradaValida = true;
                } else {
                    System.out.println("❌ Error: Operación no válida.");
                }
            }
            
            // PASO 3: Pedir segundo número con try-catch
            entradaValida = false;
            while (!entradaValida) {
                try {
                    System.out.print("Ingresa el segundo número: ");
                    num2 = scanner.nextDouble();
                    entradaValida = true;
                    
                } catch (InputMismatchException e) {
                    System.out.println("❌ Error: Debes ingresar un número válido.");
                    scanner.next();
                }
            }
            
            // PASO 4: Realizar el cálculo con switch
            double resultado = 0;
            boolean operacionExitosa = true;
            
            switch (operacion) {
                case "+":
                    resultado = num1 + num2;
                    break;  // Sale del switch
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {  // Validación con if (no con try-catch)
                        System.out.println("❌ Error: No se puede dividir entre cero.");
                        operacionExitosa = false;
                    } else {
                        resultado = num1 / num2;
                    }
                    break;
            }
            
            // PASO 5: Mostrar resultado
            if (operacionExitosa) {
                System.out.println("\n✅ Resultado: " + num1 + " " + operacion + " " + num2 + " = " + resultado);
            }
            
            // PASO 6: Preguntar si quiere continuar
            System.out.print("\n¿Deseas realizar otra operación? (s/n): ");
            String respuesta = scanner.next();
            if (!respuesta.equalsIgnoreCase("s")) {  // equalsIgnoreCase ignora mayúsculas
                continuar = false;
                System.out.println("\n¡Gracias por usar la calculadora! 👋");
            }
            System.out.println(); // Línea en blanco para separar
        }
        
        scanner.close();
    }
}