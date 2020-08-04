package com.eeswan.software.ch02.step1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private BankTransaction parseFromCSV(final String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0]);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        return new BankTransaction(date, amount, description);
    }

    public List<BankTransaction> parseLinesFromCSV(final List<String> lines) {
        List<BankTransaction> bankTransactions = new ArrayList<>();
        for(String line : lines) {
            BankTransaction bankTransaction = parseFromCSV(line);
            bankTransactions.add(bankTransaction);
        }
        return bankTransactions;
    }
}
