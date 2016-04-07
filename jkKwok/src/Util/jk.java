/*
 * Copyright (C) 2015 Kwok Jun Kiat
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
package Util;

/**
 *
 * @author jkKwok
 */
import java.io.*;
import java.net.*;
import java.util.*;

final public class jk {

    final <T> void test() {

    }

    final public static double roundOff(double x, int dp) {
        double y = Math.pow(0.1, dp) * 0.5;
        x += y;
        x = Math.floor(x * Math.pow(10, dp)) / Math.pow(10, dp);
        return x;
    }

    final public static ArrayList<String> website(String x) {
        if (!x.substring(0, 8).equals("https://") && !x.substring(0, 7).equals("http://")) {
            x = "https://" + x;
        }
        ArrayList<String> s = new ArrayList();
        try (BufferedReader in = new BufferedReader(new InputStreamReader((new URL(x)).openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                s.add(inputLine);
            }
        } catch (Exception e) {
        }
        return s;
    }

    final public static void download(String x) {
        if (!x.substring(0, 8).equals("https://") && !x.substring(0, 7).equals("http://")) {
            x = "https://" + x;
        }
        try (BufferedInputStream in = new BufferedInputStream((new URL(x)).openStream())) {
            FileOutputStream out = new FileOutputStream(piece(x, 0, "/"));
            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1) {
                out.write(data, 0, count);
            }
        } catch (Exception e) {
        }
    }

    final public static int Int(String x) {
        return Integer.parseInt(x);
    }

    final public static int Int(char x) {
        return Character.digit(x, 10);
    }

    final public static int Int(String x, int y) {
        return Int(x.charAt(y));
    }

    final public static String piece(String s, int i) {
        if (i != 0) {
            return s.split(" ")[i];
        } else {
            return s.split(" ")[s.split(" ").length - 1];
        }
    }

    final public static String piece(String s) {
        return s.split(" ")[0];
    }

    final public static String piece(String s, int i, String r) {
        if (i != 0) {
            return s.split(r)[i];
        } else {
            return s.split(r)[s.split(r).length - 1];
        }
    }

    final public static String piece(String s, String r) {
        return s.split(r)[0];
    }

    final public static void p(Object[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + " ");
        }
        p(x[x.length - 1]);
    }

    final public static void p(String[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println(x[x.length - 1]);
    }

    final public static void p(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + " ");
        }
        p(x[x.length - 1]);
    }

    final public static void p(char[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println(x[x.length - 1]);
    }

    final public static void p(float[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println(x[x.length - 1]);
    }

    final public static void p(double[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println(x[x.length - 1]);
    }

    final public static void p(boolean[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            System.out.print(x[i] + " ");
        }
        System.out.println(x[x.length - 1]);
    }

    final public static void p(Object x) {
        System.out.println(x);
    }

    public static ArrayList<Integer> splitStringByInt(String input) throws NumberFormatException {
        char[] str = input.toCharArray();
        ArrayList<Integer> list = new ArrayList<>();
        String hold = Constants.EMPTY_STRING;
        int holdType = -1;
        int type;

        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            if (Character.isDigit(c)) {
                type = 1;
            } else if (Character.isAlphabetic(c)) {
                throw new NumberFormatException();
            } else {
                type = 0;
            }
            if (type != holdType) {
                if (!hold.equals(Constants.EMPTY_STRING)) {
                    list.add(Integer.parseInt(hold));
                }
                if (type != 0) {
                    hold = Constants.EMPTY_STRING + c;
                } else {
                    hold = Constants.EMPTY_STRING;
                }
                holdType = type;
            } else {
                if (type != 0) {
                    hold += c;
                }
            }
        }
        list.add(Integer.parseInt(hold));
        return list;
    }

    public static String[] splitStringByCharType(String input) {
        char[] str = input.toCharArray();
        ArrayList<String> list = new ArrayList<>();
        String hold = Constants.EMPTY_STRING;
        int holdType = -1;

        for (int i = 0; i < str.length; i++) {
            char c = str[i];
            int type = getCharType(c);
            if (type != holdType) {
                if (!hold.equals(Constants.EMPTY_STRING)) {
                    list.add(hold);
                }
                if (type != 0) {
                    hold = Constants.EMPTY_STRING + c;
                } else {
                    hold = Constants.EMPTY_STRING;
                }
                holdType = type;
            } else {
                if (type != 0) {
                    hold += c;
                }
            }
        }
        list.add(hold);
        return list.toArray(new String[list.size()]);
    }

    public static int getCharType(char c) {
        if (Character.isDigit(c)) {
            return 1;
        } else if (Character.isLetter(c)) {
            return 2;
        } else {
            return 0;
        }
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static int monthValue(String s) {
        for (int i = 0; i < Constants.month.length; i++) {
            if (s.equalsIgnoreCase(Constants.month[i])) {
                return (i + 1) % 12;
            }
        }
        return -1;
    }
}
