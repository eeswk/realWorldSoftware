
package com.eeswan.software.ch02.step3;

import com.eeswan.software.ch02.step1.BankTransaction;
import java.util.List;

public interface BankStatementParser {
    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
