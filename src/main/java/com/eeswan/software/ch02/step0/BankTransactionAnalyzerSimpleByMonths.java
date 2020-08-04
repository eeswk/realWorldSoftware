package com.eeswan.software.ch02.step0;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimpleByMonths {
    private static final String RESOURCE = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        String fileName = args.length == 0 ? "bank-data-simple.csv" : args[0];
        final Path path = Paths.get(RESOURCE + fileName);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (String line : lines) {
            final String[] columns = line.split(",");
            final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
            if (date.getMonth() == Month.JANUARY) {
                final double amount = Double.parseDouble(columns[1]);
                total += amount;
            }
        }
        System.out.println("The total for all transactions in January is " +  total);
    }
}
