package com.abselyamov.javacore.chapter18.uml;


import java.util.Iterator;

/**
 * @author Enver on 01.06.2019 19:29.
 * @project javacore
 */
public class ArrayListDemo<E>
        extends AbstractListDemo<E>
        implements ListDemo<E>, RandomAccessDemo, Cloneable, java.io.Serializable {

    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
