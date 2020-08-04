package com.eeswan.software.ch03.step3;

public class HtmlExporter implements Export {
    @Override
    public String export(SummaryStatistics summaryStatistics) {
        String result = "<!DOCTYPE html>";
        result += "<head><title>Bank Transaction Report</title></head>";
        result += "<body>";
        result += "<ul>";
        result += "<li><strong>The sum is </strong> " + summaryStatistics.getSum() + "</li>";
        result += "<li><strong>The average is </strong> " + summaryStatistics.getAverage() + "</li>";
        result += "<li><strong>The max is </strong> " + summaryStatistics.getMax() + "</li>";
        result += "<li><strong>The min is </strong> " + summaryStatistics.getMin() + "</li>";
        result += "</ul>";
        result += "</body>";
        result += "</html>";
        return result;
    }
}
