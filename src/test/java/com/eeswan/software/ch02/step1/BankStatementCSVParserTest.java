package com.eeswan.software.ch02.step1;

import com.eeswan.software.ch02.step3.BankStatementCVSParserImpl;
import com.eeswan.software.ch02.step3.BankStatementParser;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BankStatementCSVParserTest {

    private final BankStatementParser statementParser = new BankStatementCVSParserImpl();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        final String line = "2017-01-30,-50,Tesco";
        final BankTransaction result = statementParser.parseFrom(line);

        final BankTransaction expected
                = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30),-50, "Tesco");
        final double tolerance = 0.0d;

        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
        Assert.assertEquals(expected.getDescription(), result.getDescription());

    }

}