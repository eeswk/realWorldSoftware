package com.eeswan.software.ch03.step2;

import com.eeswan.software.ch02.step1.BankTransaction;
import com.eeswan.software.ch03.step1.BankTransactionFilter;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessorOCPFinal {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessorOCPFinal(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }
    public double summarizeTranscations(final BankTransactionSummarizer bankTransactionSummarizer) {
        double result = 0d;
        for (final  BankTransaction bankTransaction : bankTransactions) {
            result = bankTransactionSummarizer.summarize(result, bankTransaction);
        }
        return result;
    }
    public double calculateTotalInMonth(final Month month) {
        return summarizeTranscations((acc, bankTransaction) ->
                bankTransaction.getDate().getMonth() == month ? acc + bankTransaction.getAmount() : acc);
    }

    public List<BankTransaction> findTransactionsGreaterThanEqual(final int amount) {
        return findTransactions(bankTransaction -> bankTransaction.getAmount() >= amount);
    }


    public List<BankTransaction> findTransactions(final BankTransactionFilter bankTransactionFilter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (BankTransaction bankTransaction : bankTransactions) {
            if(bankTransactionFilter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

}
