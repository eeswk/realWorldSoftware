package com.eeswan.software.ch02.step2;

import com.eeswan.software.ch02.step1.BankStatementCSVParser;
import com.eeswan.software.ch02.step1.BankTransaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

public class BankTransactionAnalyzerSRPwithCohesion {
    private static final String RESOURCE = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
        String fileName = args.length == 0 ? "bank-data-simple.csv" : args[0];
        final Path path = Paths.get(RESOURCE + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }

}
