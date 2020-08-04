package com.eeswan.software.ch03.step1;

import com.eeswan.software.ch02.step1.BankTransaction;
import com.eeswan.software.ch02.step3.BankStatementParser;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzerOCP {
    private static final String RESOURCE = "src/main/resources/";

    public void analyze(final String fileName, final BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCE + fileName);
        final List<String> lines = Files.readAllLines(path);
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
        final BankStatementProcessorOCP bankStatementProcessor = new BankStatementProcessorOCP(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(BankStatementProcessorOCP bankStatementProcessor) {

        System.out.println("The total for transactions in February and amount 1_000 over is " + bankStatementProcessor.findTransactions(new BnakTransctionIsInFebruaryAndExpencsive()));

        final List<BankTransaction> transactions = bankStatementProcessor.findTransactions(bankTransaction ->
                bankTransaction.getDate().getMonth() == Month.FEBRUARY
                && bankTransaction.getAmount() > 1_000);
        System.out.println(transactions);
    }

}
