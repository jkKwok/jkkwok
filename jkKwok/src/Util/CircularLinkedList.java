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
final public class CircularLinkedList<T> {

    Node head;
    private int length;

    public <T> CircularLinkedList() {
        length = 0;
    }
    
    final public Object get(int index){
        if(head!=null){
            Node curr = head;
            for(int i=0;i<index;i++){
                curr = curr.next;
            }
            return curr.get();
        }
        return null;
    }

    final public void addFirst(T a) {
        add(0, a);
    }

    final public void add(int index, T a) {
        Node l = new Node(a);
        if (head == null) {
            head = l;
        } else if (length == 1) {
            head.next = l;
            head.prev = l;
            l.next = head;
            l.prev = head;
            if(index == 0){
                head = head.next;
            }
        } else if(index == length){
            l.prev = head.prev;
            l.next = head;
            head.prev.next = l;
            head.prev = l;
        }else {
            Node curr = head;
            if (index >= 0) {
                for (int i = 0; i < index; i++) {
                    curr = curr.next;
                }
            } else {
                for (int i = 0; i > index; i--) {
                    curr = curr.prev;
                }
            }
            curr.prev.next = l;
            l.prev = curr.prev;
            l.next = curr;
            curr.prev = l;
            if (curr.equals(head)) {
                head = curr.prev;
            }
        }
        length++;
    }

    final public void add(T l) {
        add(length, l);
    }

    final public void addLast(T l) {
        add(length, l);
    }

    final public Object remove() {
        if (head != null) {
            if (length == 1) {
                head = null;
            } else {
                head.prev.next = head.next;
                head.next.prev = head.prev;
                Node hold = head;
                head = head.next;
                length--;
                return hold;
            }
            length--;
        }
        return null;
    }

    final public boolean remove(T a) {
        Node curr = head;
        for (int i = 0; i < length; i++) {
            if (a.toString().equals(curr.get().toString())) {
                if (curr.equals(head) && length == 1) {
                    head = null;
                } else if (curr.equals(head) && length == 2) {
                    head = head.next;
                    head.prev = null;
                    head.next = null;
                } else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                    if(curr.equals(head)){
                        head = head.next;
                    }
                }
                length--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    final public Object remove(int index) {
        Node curr;
        if (head != null) {
            length--;
            if (length == 0) {
                curr = head;
                head = null;
                return curr;
            } else {
                curr = head;
                if (index >= 0) {
                    for (int i = 0; i < index; i++) {
                        curr = curr.next;
                    }
                } else {
                    for (int i = 0; i > index; i--) {
                        curr = curr.prev;
                    }
                }
                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                if (curr.equals(head)) {
                    head = head.next;
                }
                return curr;
            }
        }
        return null;
    }

    final public int size() {
        return length;
    }

    public String toString() {
        String temp = "";
        Node curr = head;
        for (int i = 0; i < length-1; i++) {
            temp += curr.get().toString()+" ";
            curr = curr.next;
        }
        temp += curr.get().toString();
        return temp;
    }
}
