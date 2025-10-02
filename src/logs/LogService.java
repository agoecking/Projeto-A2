package logs;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Classe responsável por registrar logs em um arquivo TXT.
 */
public class LogService {

    private static final String LOG_FILE = "logs.txt";

    /**
     * Registra uma ação no arquivo de logs com data e hora.
     *
     * @param mensagem Mensagem do log
     */
    public static void registrar(String mensagem) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            String dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            writer.write("[" + dataHora + "] " + mensagem);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao escrever no log: " + e.getMessage());
        }
    }
}
