import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class App {
    public static void main (String[] args) throws IOException {
        FileInputStream in = new FileInputStream( "MisDatosUV.txt");
        FileOutputStream out = new FileOutputStream("bytePrueba2.txt");
        try {
            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }

        } catch (IOException ex) {
            System.out.println("Error: No fue posible instanciar el objeto in" + ex.getMessage());
            ex.getMessage();
            ex.printStackTrace();

        } finally {
            if (in != null) in.close();
            if (out != null) out.close();
        }
    }
}
