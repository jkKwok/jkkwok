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
import Util.*;
import java.util.ArrayList;

public class NaturalTime {

    public static String getTime(String input) {
        input = input.trim();
        ArrayList<Integer> result;
        try {
            result = jk.splitStringByInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
        int hour, minute;
        if (result.size() == 1) {
            minute = 0;
            hour = result.get(0);
            if (hour > 100) {
                minute = hour % 100;
                hour /= 100;
            }
            if (!isHour(hour)) {
                return null;
            }
        } else if (result.size() == 2) {
            hour = result.get(0);
            if (!isHour(hour)) {
                return null;
            }
            minute = result.get(1);
            if (!isMinute(minute)) {
                return null;
            }
        } else {
            return null;
        }
        return String.format(Constants.TIME_FORMAT, hour, minute);
    }

    private static boolean isHour(int s) {
        return (s >= 0 && s < 24);
    }

    private static boolean isMinute(int s) {
        return (s >= 0 && s < 60);
    }
}
