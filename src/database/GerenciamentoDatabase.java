package database;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import logs.LogService;

//classe responsável pelo gerenciamento dos arquivos txt, será chamada pelos repositórios
public class GerenciamentoDatabase {

    private static final String CAMINHO_BASE = "src/database/";

    public static void salvar(String arquivo, String linha) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_BASE + arquivo, true))) {
            writer.write(linha);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar no arquivo: " + e.getMessage());
            LogService.registrar("mensagem");
        }
    }

    public static List<String> carregar(String arquivo) {
        List<String> linhas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CAMINHO_BASE + arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            LogService.registrar("mensagem");
        }
        return linhas;
    }

    public static void salvarLista(String arquivo, List<String> linhas) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CAMINHO_BASE + arquivo, false))) { 
            for (String linha : linhas) {
                writer.write(linha);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar lista no arquivo: " + e.getMessage());
            LogService.registrar("mensagem");
        }
    }
}
