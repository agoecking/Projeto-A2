package database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por salvar e carregar dados em arquivos TXT.
 */
public class GerenciamentoDatabase {

    /**
     * Salva uma linha em um arquivo TXT.
     * Se o arquivo não existir, ele será criado.
     *
     * @param arquivo Nome do arquivo (ex: "agendamentos.txt")
     * @param linha   Texto a ser salvo
     */
    public static void salvar(String arquivo, String linha) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true))) {
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
        }
    }

    /**
     * Carrega todas as linhas de um arquivo TXT.
     *
     * @param arquivo Nome do arquivo (ex: "agendamentos.txt")
     * @return Lista de linhas do arquivo
     */
    public static List<String> carregar(String arquivo) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return linhas;
    }
}