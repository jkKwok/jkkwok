/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Util.CircularLinkedList;
import java.util.LinkedList;
import java.util.Vector;

/**
 *
 * @author JunKiat
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CircularLinkedList<Integer> c = new CircularLinkedList();
//        c.add(new Node('a'));
//        c.add(new Node('b'));
//        c.add(new Node("c"));
//        jk.p(c);
//        c.remove();
//        jk.p(c);
//        jk.p(c.remove(new Node("c")));
//        jk.p(c);
//        c.add(new Node("a"));
//        jk.p(c);
//        c.add(1,new Node("c"));
//        jk.p(c.size() + " " +c);
//        c.remove(new Node("b"));
//        jk.p(c.size() + " " +c);
        
//        jk.p(new int[]{0,1});
//        Node[] a = new Node[10];
//        for(int i=0;i<10;i++){
//            a[i] = new Node(new Node("sdafs"));
//        }
//        jk.p(a);
//        LinkedList n;
//        
//        c.add(-1,0);
//        jk.p(c);
//        c.add(-1,1);
//        jk.p(c);
//        c.add(-1,2);
//        jk.p(c);
//        c.add(-1,3);
//        jk.p(c);
//        c.add(-1,4);
//        jk.p(c);
//        c.add(-1,5);
//        jk.p(c);
        
        Vector list = new Vector();
        for(int i=0;i<6;i++){
            list.add(1);
        }
        //Object ob = list.get(6); 
        //Integer  intOb = list.get(2);
        //list.add(6, new  Integer(9));
        Object x = list.remove(6);
        Object y = list.set(6, new Integer(8));
    }
}