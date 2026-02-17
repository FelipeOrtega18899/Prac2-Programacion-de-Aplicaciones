public class VerificadorNumeros {

    public static void main(String[] args) {
        // Ejemplo 1: Probando con un número par
        probarNumero(10);

        // Ejemplo 2: Probando con un número impar
        probarNumero(7);
    }

    /**
     * Método que verifica si un número es par.
     * @param numero El entero a evaluar.
     * @throws IllegalArgumentException si el número es impar.
     */
    public static void verificarSiEsPar(int numero) {
        if (numero % 2 != 0) {
            // Lanzamos la excepción con un mensaje descriptivo
            throw new IllegalArgumentException("Error: El número " + numero + " es impar.");
        }
        System.out.println("Éxito: El número " + numero + " es par.");
    }

    // Método auxiliar para no repetir el try-catch en el main
    public static void probarNumero(int n) {
        try {
            verificarSiEsPar(n);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}