package com.abselyamov.javacore.chapter18.uml;

/**
 * @author Enver on 01.06.2019 17:50.
 * @project javacore
 */
public interface QueueDemo<E> extends CollectionDemo<E> {

    public boolean add(Object o);

    public boolean offer(Object o);

    public E remove();

    public E poll();

    public E element();

    public E peek();
}
