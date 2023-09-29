package equiv;

import java.util.LinkedList;
import java.util.List;

/**
 * Equiv - A generic class that supports maintaining equivalence relations between elements of type E.
 *
 * @param <E> the type of elements in the equivalence relation
 */
public class Equiv<E> {
    private List<LinkedList<E>> equivList;

    /**
     * Constructs an empty Equiv object.
     * The equivalence relation is initially empty, with no elements.
     */
    public Equiv() {
        equivList = new LinkedList<>();
    }

    /**
     * Adds a pair of elements (e1, e2) to the equivalence relation.
     * If either e1 or e2 already exist in the relation, it merges their respective sets.
     * Otherwise, it creates a new set containing both elements.
     *
     * @param e1 the first element of the pair
     * @param e2 the second element of the pair
     */
    public void add(E e1, E e2) {
        LinkedList<E> checkFirstE = null;
        LinkedList<E> checkSecondE = null;

        for (LinkedList<E> currentE : equivList) {
            if (currentE.contains(e1)) {
                checkFirstE = currentE;
            }
            if (currentE.contains(e2)) {
                checkSecondE = currentE;
            }
        }

        if (checkFirstE != null && checkSecondE != null) {
            if (!checkFirstE.equals(checkSecondE)) {
                checkFirstE.addAll(checkSecondE);
                equivList.remove(checkSecondE);
            }
        } else if (checkFirstE != null) {
            checkFirstE.add(e2);
        } else if (checkSecondE != null) {
            checkSecondE.add(e1);
        } else {
            LinkedList<E> newSet = new LinkedList<>();
            newSet.add(e1);
            newSet.add(e2);
            equivList.add(newSet);
        }
    }

    /**
     * Checks if two elements (e1, e2) are equivalent.
     * Returns true if they belong to the same equivalence set, false otherwise.
     *
     * @param e1 the first element to check
     * @param e2 the second element to check
     * @return true if e1 and e2 are equivalent, false otherwise
     */
    public boolean are(E e1, E e2) {
        if (e1.equals(e2)) {
            return true;
        }

        for (LinkedList<E> currentE : equivList) {
            if (currentE.contains(e1) && currentE.contains(e2)) {
                return true;
            }
        }

        return false;
    }
}
