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
package Util;

/**
 *
 * @author Kwok
 * @param <E>
 */
public class heap<E extends Comparable> {

    private Object[] array;
    int size = 0;
    boolean reverse = false;

    public heap() {
        array = new Object[1];
    }

    public void offer(E tr) {
        size++;
        try {
            array[size] = tr;
        } catch (Exception e) {
            expand();
            array[size] = tr;
        }
        swim(size);
    }

    private void expand() {
        int newsize = array.length * 2;
        Object[] newarray = new Object[newsize];
        System.arraycopy(array, 1, newarray, 1, size - 1);
        array = newarray;
    }

    private void swim(int k) {
        if (!reverse) {
            while (k > 1 && ((E) array[k / 2]).compareTo((E) array[k]) < 0) {
                Object temp = array[k / 2];
                array[k / 2] = array[k];
                array[k] = temp;
                k = k / 2;
            }
        } else {
            while (k > 1 && ((E) array[k / 2]).compareTo((E) array[k]) > 0) {
                Object temp = array[k / 2];
                array[k / 2] = array[k];
                array[k] = temp;
                k = k / 2;
            }
        }
    }

    public E poll() {
        E max = (E) array[1];
        array[1] = array[size];
        array[size] = null;
        size--;
        sink(1);
        return max;
    }

    private void sink(int k) {
        if (!reverse) {
            while (2 * k <= size) {
                int j = 2 * k;
                if (j < size && ((E) array[j]).compareTo((E) array[j + 1]) < 0) {
                    j++;
                }
                if (((E) array[k]).compareTo((E) array[j]) > 0) {
                    break;
                }
                Object temp = array[j];
                array[j] = array[k];
                array[k] = temp;
                k = j;
            }
        } else {
            while (2 * k <= size) {
                int j = 2 * k;
                if (j < size && ((E) array[j]).compareTo((E) array[j + 1]) > 0) {
                    j++;
                }
                if (((E) array[k]).compareTo((E) array[j]) < 0) {
                    break;
                }
                Object temp = array[j];
                array[j] = array[k];
                array[k] = temp;
                k = j;
            }
        }
    }

    public E peek() {
        return (E) array[1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        try {
            String s = array[1].toString();
            for (int i = 2; i <= size; i++) {
                s += "," + array[i].toString();
            }
            return s;
        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
    }

    public void toggle() {
        reverse = true;
    }
}
