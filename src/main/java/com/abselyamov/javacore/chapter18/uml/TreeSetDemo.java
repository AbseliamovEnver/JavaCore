package com.abselyamov.javacore.chapter18.uml;

import java.util.Iterator;

/**
 * @author Enver on 01.06.2019 19:43.
 * @project javacore
 */
public class TreeSetDemo<E>
        extends AbstractSetDemo<E>
        implements NavigableSetDemo<E>, Cloneable, java.io.Serializable {

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
