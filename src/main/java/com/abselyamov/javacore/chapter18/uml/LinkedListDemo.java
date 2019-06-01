package com.abselyamov.javacore.chapter18.uml;

import java.util.Iterator;

/**
 * @author Enver on 01.06.2019 19:31.
 * @project javacore
 */
public class LinkedListDemo<E>
        extends AbstractSequentialListDemo<E>
        implements ListDemo<E>, DequeueDemo<E>, Cloneable, java.io.Serializable {

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean offer(Object o) {
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

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
