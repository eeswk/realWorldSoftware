package com.eeswan.software.ch03.step2;

import com.eeswan.software.ch02.step1.BankTransaction;

@FunctionalInterface
public interface BankTransactionSummarizer {
    double summarize(double accumulator, BankTransaction bankTransaction);
}
