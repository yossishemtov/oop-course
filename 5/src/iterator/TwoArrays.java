package iterator;

import java.util.Iterator;

public class TwoArrays implements Iterable<Integer> {
    private int[] a1, a2;

    /**
     * Constructs a TwoArrays object with two integer arrays.
     *
     * @param a1 the first integer array
     * @param a2 the second integer array
     */
    public TwoArrays(int[] a1, int[] a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    /**
     * Returns an iterator over the elements of the TwoArrays object.
     *
     * @return an iterator
     */
    @Override
    public Iterator<Integer> iterator() {
        return new MyIterator();
    }

    /**
     * Custom iterator implementation for iterating over elements of two arrays.
     */
    private class MyIterator implements Iterator<Integer> {
        private int cur1, cur2, choose = 1;

        /**
         * Checks if there are more elements to iterate over.
         *
         * @return true if there are more elements, false otherwise
         */
        @Override
        public boolean hasNext() {
            return cur1 < a1.length || cur2 < a2.length;
        }

        /**
         * Retrieves the next element in the iteration.
         *
         * @return the next element
         */
        @Override
        public Integer next() {
            if (hasNext()) {
                if (choose == 1) {
                    if (cur1 < a1.length) {
                        cur1++;
                        choose = 2;
                        return a1[cur1 - 1];
                    } else {
                        cur2++;
                        choose = 2;
                        return a2[cur2 - 1];
                    }
                } else if (choose == 2) {
                    if (cur2 < a2.length) {
                        cur2++;
                        choose = 1;
                        return a2[cur2 - 1];
                    } else {
                        cur1++;
                        choose = 1;
                        return a1[cur1 - 1];
                    }
                }
            }
            return null;
        }
    }
}
