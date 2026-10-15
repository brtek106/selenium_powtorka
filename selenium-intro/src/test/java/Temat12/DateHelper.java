package Temat12;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class DateHelper {
    private static final String DATE_PICKER_DATE_FORMAT = "MM/dd/yyyy";

    private static final String DATE_PICKER_TITLE_DATE_FORMAT = "MMMM yyyy";

    protected static int getDayFromDate(String date) {
        LocalDate localDate = DateHelper.parseDate(date, DATE_PICKER_DATE_FORMAT);
        int dayOfMonth = localDate.getDayOfMonth();
        return dayOfMonth;
    }

    protected static long getDateDifferenceInMonths(String actualTitleDate, String dateToSelect) {
        LocalDate actualLocalDate = parseDate(actualTitleDate, DATE_PICKER_DATE_FORMAT);
        LocalDate dateToSelectLocalDate = parseDate(dateToSelect, DATE_PICKER_TITLE_DATE_FORMAT);

        long differenceOfMonths = YearMonth.from(dateToSelectLocalDate).until(actualLocalDate, ChronoUnit.MONTHS);
        return differenceOfMonths;
    }

    private static LocalDate parseDate(String dateToParse, String dateFormat) {
        DateFormat dateFormatCurrent = new SimpleDateFormat(dateFormat, Locale.ENGLISH);
        Date parsedDate = null;

        try {
            parsedDate = dateFormatCurrent.parse(dateToParse);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalStateException("There was an exception while parsing date: " + dateFormat);
        }
        return parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
