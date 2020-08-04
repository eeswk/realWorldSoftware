package com.eeswan.software.ch03.step4;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class OverlySpecificVankStatementValidator {

    private String description;
    private String date;
    private String amount;

    public OverlySpecificVankStatementValidator(String description, String date, String amount) {
        this.description = description;
        this.date = date;
        this.amount = amount;
    }

    public boolean validate() throws DescrptionTooLongException,
            InvalidDateFormat,
            DateInTheFutureException,
            InvalidAmountException {
        if (this.description.length() >100) {
            throw new DescrptionTooLongException();
        }
        final LocalDate parseDate;
        try {
            parseDate = LocalDate.parse(this.date);
        } catch (DateTimeParseException e) {
            throw new InvalidDateFormat();
        }
        if (parseDate.isAfter(LocalDate.now())) throw new DateInTheFutureException();

        try {
            Double.parseDouble(this.amount);
        } catch (NumberFormatException e) {
            throw new InvalidAmountException();
        }
        return true;
    }

    public boolean validate2() {
        if (this.description.length() >100) {
            throw new IllegalArgumentException("The description is too long");
        }
        final LocalDate parseDate;
        try {
            parseDate = LocalDate.parse(this.date);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid format for date", e);
        }
        if (parseDate.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("date cannot be in the furture");

        try {
            Double.parseDouble(this.amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid format for amount", e);
        }
        return true;
    }

    public Notification validate3() {
        final Notification notification = new Notification();
        if (this.description.length() > 100) {
            notification.addError("The Description is too long");
        }
        final LocalDate parsedDate;
        try {
            parsedDate = LocalDate.parse(this.date);
            if (parsedDate.isAfter(LocalDate.now())) {
                notification.addError("date cannot be in the furture");
            }
        } catch (DateTimeParseException e) {
            notification.addError("Invalid format for date");
        }
        final double amount;
        try {
            amount = Double.parseDouble(this.amount);
        } catch (NumberFormatException e) {
            notification.addError("Invalid format for amount");
        }
        return notification;
    }
}
