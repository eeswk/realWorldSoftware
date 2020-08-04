package com.eeswan.software.ch03.step1;

import com.eeswan.software.ch02.step1.BankTransaction;
import java.time.Month;

public class BnakTransctionIsInFebruaryAndExpencsive implements BankTransactionFilter {
    @Override
    public boolean test(final BankTransaction bankTransaction) {
        return bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() >= 1_000;
    }
}
