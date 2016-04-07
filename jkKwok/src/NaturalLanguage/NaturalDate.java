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
import Util.Constants;
import Util.jk;
import java.util.Calendar;

public class NaturalDate {

    public static String getDate(String input) {
        input = input.trim();
        String[] result = jk.splitStringByCharType(input);
        if (result.length > 3 || result.length < 2) {
            return null;
        }
        boolean confirmMonth = false;
        boolean confirmYear = false;
        int month = -1;
        int day = -1;
        int year = -1;
        for (int i = 0; i < result.length; i++) {
            String s = result[i];
            if (!jk.isInteger(s)) {
                if (!confirmMonth) {
                    int monthValue = jk.monthValue(s);
                    if (monthValue == -1) {
                        return null;
                    } else {
                        confirmMonth = true;
                        month = monthValue;
                    }
                } else {
                    return null;
                }
            } else {
                int temp = Integer.parseInt(s);
                switch (i) {
                    case 0:
                        if (isDay(temp)) {
                            day = temp;
                        } else if (!confirmYear) {
                            confirmYear = true;
                            year = temp;
                        } else {
                            return null;
                        }
                        break;
                    default:
                        if (isMonth(temp) && !confirmMonth) {
                            month = temp;
                            confirmMonth = true;
                        } else if (isDay(temp) && !confirmMonth && isMonth(day)) {
                            month = day;
                            day = temp;
                        } else if (isDay(temp) && day == -1) {
                            day = temp;
                        } else if (!confirmYear) {
                            confirmYear = true;
                            year = temp;
                        } else {
                            return null;
                        }
                        break;
                }
            }
        }
        return finaliseDate(year, month, day);
    }

    private static String finaliseDate(int year, int month, int day) {
        if (year == -1) {
            year = Calendar.getInstance().get(Calendar.YEAR);
        }
        if (year < 1000) {
            year += 2000;
        }
        String output = String.format(Constants.DATE_FORMAT, year, month, day);
        if (Date.isLegalDate(output)) {
            return output;
        } else {
            return null;
        }
    }

    private static boolean isDay(int s) {
        return (s > 0 && s < 32);
    }

    private static boolean isMonth(int s) {
        return (s > 0 && s < 13);
    }
}
