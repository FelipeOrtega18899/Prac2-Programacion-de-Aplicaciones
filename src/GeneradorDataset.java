import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Locale;

public class GeneradorDataset {

    public static void main(String[] args) {
        String[] rangos = {"asistente", "asociado", "titular"};
        Random random = new Random();
        int cantidadLineas = 1000;

        try (PrintWriter out = new PrintWriter(new File("salarios.txt"))) {

            for (int i = 1; i <= cantidadLineas; i++) {
                int indiceRango = random.nextInt(3);
                String rangoSeleccionado = rangos[indiceRango];
                double salario = 0.0;

                switch (indiceRango) {
                    case 0:
                        salario = 50000 + (30000 * random.nextDouble());
                        break;
                    case 1:
                        salario = 60000 + (50000 * random.nextDouble());
                        break;
                    case 2:
                        salario = 75000 + (55000 * random.nextDouble());
                        break;
                }

                out.printf(Locale.US, "Nombre%d Apellido%d %s %.2f%n", i, i, rangoSeleccionado, salario);
            }

            System.out.println("Éxito: Se generó el archivo 'salarios.txt'.");

        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}