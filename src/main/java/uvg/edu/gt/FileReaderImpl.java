package uvg.edu.gt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Implementación de una clase para leer el contenido de un archivo de texto.
 */
public class FileReaderImpl {
    
    /**
     * Lee el contenido de un archivo de texto dado su ruta.
     *
     * @param filePath Ruta del archivo de texto.
     * @return El contenido del archivo de texto como una cadena de caracteres.
     * @throws IOException si ocurre un error al leer el archivo.
     */
    public static String readFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                contentBuilder.append(currentLine).append("\n");
            }
        }
        return contentBuilder.toString();
    }
}

