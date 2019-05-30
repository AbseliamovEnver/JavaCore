package com.abselyamov.javacore.chapter18;

import java.util.*;

/**
 * @author Enver on 30.05.2019 17:57.
 * @project javacore
 * <p>
 * class PriorityQueue<E> extends AbstractQueue implements Queue.
 */
public class PriorityQueueDemo {

    Collection<String> collection = new ArrayList<String>();
    Collection<String> sortedSet = new TreeSet<String>();

    PriorityQueue<String> priorityQueue = new PriorityQueue();
    PriorityQueue<String> priorityQueue2 = new PriorityQueue(50);
    PriorityQueue<String> priorityQueue3 = new PriorityQueue((new MyComparatorPQ()));
    PriorityQueue<String> priorityQueue4 = new PriorityQueue(50, (new MyComparatorPQ()));
    PriorityQueue<String> priorityQueue5 = new PriorityQueue<String>(collection);
    PriorityQueue<String> priorityQueue6 = new PriorityQueue<String>(priorityQueue);
    PriorityQueue<String> priorityQueue7 = new PriorityQueue<String>(sortedSet);
}

class MyComparatorPQ implements Comparator<String> {
    public int compare(String a, String b) {
        String aStr, bStr;
        aStr = a;
        bStr = b;
        return bStr.compareTo(aStr);
    }
}