package com.eeswan.software.ch03.step1;

import com.eeswan.software.ch02.step1.BankTransaction;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessorOCP {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessorOCP(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
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



    public double calculateTotalAmount() {
        double total = 0d;
        for (BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0d;
        for (BankTransaction bankTransaction :  bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0d;
        for (BankTransaction bankTransaction :  bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}
