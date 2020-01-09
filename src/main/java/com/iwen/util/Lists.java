package com.iwen.util;


import java.util.ArrayList;
import java.util.Iterator;

public class Lists {
    /** Returns a new mutable, empty {@code ArrayList} instance. */
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<E>();
    }

    /**
     * Creates an {@code ArrayList} instance backed by an array of the <i>exact</i> size specified;
     * equivalent to {@link ArrayList#ArrayList(int)}.
     *
     * @param initialArraySize the exact size of the initial backing array for the returned array list
     *        ({@code ArrayList} documentation calls this value the "capacity")
     * @return a new, empty {@code ArrayList} which is guaranteed not to resize itself unless its size
     *         reaches {@code initialArraySize + 1}
     * @throws IllegalArgumentException if {@code initialArraySize} is negative
     */
    public static <E> ArrayList<E> newArrayListWithCapacity(int initialArraySize) {
        return new ArrayList<E>(initialArraySize);
    }


    /**
     * Returns a new mutable {@code ArrayList} instance containing the given elements.
     *
     * @param elements the elements that the list should contain, in order
     * @return a new {@code ArrayList} containing those elements
     */
    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> elements) {
        ArrayList<E> list = newArrayList();
        while (elements.hasNext()) {
            list.add(elements.next());
        }
        return list;
    }

    private Lists() {
    }
}
