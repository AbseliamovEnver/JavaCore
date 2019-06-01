package com.abselyamov.javacore.chapter18.uml;


import java.util.Iterator;

/**
 * @author Enver on 01.06.2019 19:47.
 * @project javacore
 */
public class PriorityQueueDemo<E>
        extends AbstractQueueDemo<E>
        implements java.io.Serializable {

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return null;
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
