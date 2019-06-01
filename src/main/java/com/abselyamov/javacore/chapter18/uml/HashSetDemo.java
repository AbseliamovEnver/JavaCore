package com.abselyamov.javacore.chapter18.uml;

import java.util.Iterator;

/**
 * @author Enver on 01.06.2019 19:37.
 * @project javacore
 */
public class HashSetDemo<E>
        extends AbstractSetDemo<E>
        implements SetDemo<E>, Cloneable, java.io.Serializable {

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
