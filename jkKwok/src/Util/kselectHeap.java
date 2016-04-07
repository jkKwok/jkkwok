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
 * @param <e>
 */
public class kselectHeap<e extends Comparable> {

    private final heap<e> maxHeap;
    private final heap<e> minHeap;
    int k;

    public kselectHeap(int k) {
        this.k = k;
        maxHeap = new heap<>();
        minHeap = new heap<>();
        minHeap.toggle();
        System.out.println("Done");
    }

    public void insert(e element) {
        maxHeap.offer(element);
        if (maxHeap.size() > k) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public e peek() {
        if (maxHeap.size() == k) {
            return maxHeap.peek();
        } else {
            return null;
        }
    }

    public e delete() {
        if (maxHeap.size() == k) {
            e median = maxHeap.poll();
            if (!minHeap.isEmpty()) {
                maxHeap.offer(minHeap.poll());
            }
            return median;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return maxHeap.isEmpty() && minHeap.isEmpty();
    }

    @Override
    public String toString() {
        return maxHeap + " " + minHeap;
    }
}
