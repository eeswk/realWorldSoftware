package com.eeswan.software.ch03.step1;

        import com.eeswan.software.ch02.step1.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
