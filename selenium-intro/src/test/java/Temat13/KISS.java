package Temat13;

import javax.naming.directory.InvalidAttributesException;

public class KISS {

//    Metoda spełniająca zasady KISS
    public String weekday1(int day) throws InvalidAttributesException {
        switch (day) {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                throw new InvalidAttributesException("Day must be in range from 1 to 7");
        }
    }

//    Metoda nie spełniająca zasady KISS
    public String weekday2(int day) throws InvalidAttributesException {
        if ((day < 1) || (day > 7)) throw new InvalidAttributesException("Day must be in range from 1 to 7");
        String[] days = {
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday"
        };
        return days[day - 1];
    }
}
