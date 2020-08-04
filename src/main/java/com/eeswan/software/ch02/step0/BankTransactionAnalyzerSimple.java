package com.eeswan.software.ch02.step0;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCE = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        String fileName = args.length == 0 ? "bank-data-simple.csv" : args[0];
        final Path path = Paths.get(RESOURCE + fileName);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }
        System.out.println("The total for all transactions is " +  total);
    }
}
