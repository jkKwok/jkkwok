/*
 * Copyright (C) 2016 Kwok
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package NaturalLanguage;

/**
 *
 * @author Kwok
 */
public class Date {

    public static String addDay(String s) {
        int year = Integer.parseInt(s.split("/")[0]);
        int month = Integer.parseInt(s.split("/")[1]);
        int day = Integer.parseInt(s.split("/")[2]);
        day++;
        s = makeDate(year, month, day);
        if (isLegalDate(s)) {
            return s;
        }
        day = 1;
        month++;
        s = makeDate(year, month, day);
        if (isLegalDate(s)) {
            return s;
        }
        day = 1;
        month = 1;
        year++;
        s = makeDate(year, month, day);
        return s;
    }

    public static String addMonth(String s) {
        int year = Integer.parseInt(s.split("/")[0]);
        int month = Integer.parseInt(s.split("/")[1]);
        int day = Integer.parseInt(s.split("/")[2]);

        month++;
        s = makeDate(year, month, day);
        if (isLegalDate(s)) {
            return s;
        }
        day = 1;
        month = 1;
        year++;
        s = makeDate(year, month, day);
        return s;
    }

    public static String addYear(String s) {
        int year = Integer.parseInt(s.split("/")[0]);
        int month = Integer.parseInt(s.split("/")[1]);
        int day = Integer.parseInt(s.split("/")[2]);
        year++;
        return makeDate(year, month, day);
    }

    public static boolean isLegalDate(String dateString) {
        int year = Integer.parseInt(dateString.split("/")[0]);
        int month = Integer.parseInt(dateString.split("/")[1]);
        int day = Integer.parseInt(dateString.split("/")[2]);
        boolean yearOk = (year >= 1581) && (year <= 2500);
        boolean monthOk = (month >= 1) && (month <= 12);
        boolean dayOk = (day >= 1) && (day <= daysInMonth(year, month));
        return (yearOk && monthOk && dayOk);
    }

    private static int daysInMonth(int year, int month) {
        int daysInMonth;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                daysInMonth = 31;
                break;
            case 2:
                if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                    daysInMonth = 29;
                } else {
                    daysInMonth = 28;
                }
                break;
            default:
                daysInMonth = 30;
        }
        return daysInMonth;
    }

    public static String makeDate(int year, int month, int day) {
        String s = year + "/";
        if (month < 10) {
            s += 0 + "" + month + "/";
        } else {
            s += month + "/";
        }
        if (day < 10) {
            s += 0 + "" + day;
        } else {
            s += day;
        }
        return s;
    }
}
