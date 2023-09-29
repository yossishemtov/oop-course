package iterator;

import java.util.Iterator;

public class Combined<E> implements Iterable<E> {

    private Iterable<E> firstIterable, secondIterable;

    /**
     * Constructs a Combined object that combines two Iterable objects.
     *
     * @param firstIterable  the first Iterable object
     * @param secondIterable the second Iterable object
     */
    public Combined(Iterable<E> firstIterable, Iterable<E> secondIterable) {
        this.firstIterable = firstIterable;
        this.secondIterable = secondIterable;
    }

    /**
     * Returns an iterator over the elements of the Combined object.
     *
     * @return an iterator
     */
    @Override
    public Iterator<E> iterator() {
        return new CombinedIterator();
    }

    /**
     * Custom iterator implementation for iterating over combined elements.
     */
    private class CombinedIterator implements Iterator<E> {
        private Iterator<E> firstIterator = firstIterable.iterator();
        private Iterator<E> secondIterator = secondIterable.iterator();
        private int currentIterator = 1; // 1 for firstIterator, 2 for secondIterator

        /**
         * Checks if there are more elements to iterate over.
         *
         * @return true if there are more elements, false otherwise
         */
        @Override
        public boolean hasNext() {
            return firstIterator.hasNext() || secondIterator.hasNext();
        }

        /**
         * Retrieves the next element in the iteration.
         *
         * @return the next element
         */
        @Override
        public E next() {
            if (hasNext()) {
                if (currentIterator == 1) {
                    if (firstIterator.hasNext()) {
                        currentIterator = 2;
                        return firstIterator.next();
                    } else {
                        currentIterator = 2;
                        return secondIterator.next();
                    }
                } else if (currentIterator == 2) {
                    if (secondIterator.hasNext()) {
                        currentIterator = 1;
                        return secondIterator.next();
                    } else {
                        currentIterator = 1;
                        return firstIterator.next();
                    }
                }
            }
            return null;
        }
    }
}
