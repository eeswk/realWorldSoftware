package com.eeswan.software.ch02.step3;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        final BankTransactionAnalyzerSRPwithCohesionwithCoupling bankTransactionAnalyzer =
                new BankTransactionAnalyzerSRPwithCohesionwithCoupling();

        final BankStatementParser bankStatementParser = new BankStatementCVSParserImpl();

        bankTransactionAnalyzer.analyze("bank-data-simple.csv", bankStatementParser);

    }
}
