package com.eeswan.software.ch02.step3;

import com.eeswan.software.ch02.step1.BankTransaction;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCVSParserImpl implements BankStatementParser {

    @Override
    public BankTransaction parseFrom(String line) {
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(columns[0]);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        return new BankTransaction(date, amount, description);
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        List<BankTransaction> bankTransactions = new ArrayList<>();
        for(String line : lines) {
            BankTransaction bankTransaction = parseFrom(line);
            bankTransactions.add(bankTransaction);
        }
        return bankTransactions;
    }
}
