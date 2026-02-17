public class verificadorimpar {
    public static void main(String[] args) {
        try {
            verificar(5); // Esto lanzará la excepción
        } catch (IllegalArgumentException e) {
            System.out.println("Atrapado: " + e.getMessage());
        }
    }

    public static void verificar(int n) {
        if (n % 2 != 0) {
            throw new IllegalArgumentException("El número " + n + " es impar.");
        }
        System.out.println(n + " es par. Todo bien.");
    }
}