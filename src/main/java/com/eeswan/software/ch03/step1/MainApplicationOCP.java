package com.eeswan.software.ch03.step1;

import com.eeswan.software.ch02.step3.BankStatementCVSParserImpl;
import com.eeswan.software.ch02.step3.BankStatementParser;
import com.eeswan.software.ch02.step3.BankTransactionAnalyzerSRPwithCohesionwithCoupling;
import java.io.IOException;

public class MainApplicationOCP {
    public static void main(String[] args) throws IOException {
        final BankTransactionAnalyzerOCP bankTransactionAnalyzer =
                new BankTransactionAnalyzerOCP();

        final BankStatementParser bankStatementParser = new BankStatementCVSParserImpl();

        bankTransactionAnalyzer.analyze("bank-data-simple.csv", bankStatementParser);

    }
}
