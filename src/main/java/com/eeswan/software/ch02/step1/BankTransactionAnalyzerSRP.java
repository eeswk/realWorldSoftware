package com.eeswan.software.ch02.step1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BankTransactionAnalyzerSRP {
    private static final String RESOURCE = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        String fileName = args.length == 0 ? "bank-data-simple.csv" : args[0];
        final Path path = Paths.get(RESOURCE + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transactions is " +  calculateTotalAmount(bankTransactions));
        System.out.println("Transactions in January " +  selectInMonth(bankTransactions, Month.JANUARY));
    }

    private static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        /*
        double total = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
        */
        return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
    }

    private static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month) {
        /*
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
         */
         return bankTransactions.stream()
                 .filter(bankTransaction -> month.equals(bankTransaction.getDate().getMonth()))
                 .collect(Collectors.toList());
    }
}
