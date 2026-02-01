// Estudo de Caso 15.4.3 – Programa de Consulta de Crédito
// Livro: Java: Como Programar (Deitel)

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CreditInquiry {

    private static Scanner input;

    public static void main(String[] args) {
        openFile();
        readRecords();
        closeFile();
    }

    // Abre o arquivo
    public static void openFile() {
        try {
            input = new Scanner(new File("clients.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Erro ao abrir o arquivo.");
            System.exit(1);
        }
    }

    // Lê os registros sequencialmente
    public static void readRecords() {
        System.out.printf("%-10s%-12s%10s%n",
                "Conta", "Nome", "Saldo");

        while (input.hasNext()) {
            int conta = input.nextInt();
            String nome = input.next();
            double saldo = input.nextDouble();

            // Exibe todos os registros (como no estudo de caso)
            System.out.printf("%-10d%-12s%10.2f%n",
                    conta, nome, saldo);
        }
    }

    // Fecha o arquivo
    public static void closeFile() {
        if (input != null)
            input.close();
    }
}
