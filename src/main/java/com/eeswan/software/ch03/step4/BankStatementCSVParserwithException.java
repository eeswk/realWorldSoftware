package com.eeswan.software.ch03.step4;

import com.eeswan.software.ch02.step1.BankTransaction;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParserwithException {

    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final int EXCEPTION_ATTRIBUTES_LENGTH = 2;

    private BankTransaction parseFromCSV(final String line) throws CSVsyntaxException {
        final String[] columns = line.split(",");

        if(columns.length < EXCEPTION_ATTRIBUTES_LENGTH) {
            throw new CSVsyntaxException();
        }
        System.out.println(columns.length);

        final LocalDate date = LocalDate.parse(columns[0]);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        return new BankTransaction(date, amount, description);
    }

    public List<BankTransaction> parseLinesFromCSV(final List<String> lines) throws CSVsyntaxException {
        List<BankTransaction> bankTransactions = new ArrayList<>();
        for(String line : lines) {
            BankTransaction bankTransaction = parseFromCSV(line);
            bankTransactions.add(bankTransaction);
        }
        return bankTransactions;
    }
}
