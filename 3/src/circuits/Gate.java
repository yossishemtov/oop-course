package circuits;

public abstract class Gate {
    protected Gate[] inGates; // Array of input gates.

    public Gate(Gate[] inGates) {
        this.inGates = inGates;
    }

    public boolean calc() throws CircuitException {
        boolean[] inValues = (inGates != null) ? new boolean[inGates.length] : null; // Allocate memory for inValues if inGates is not null.

        if (inGates != null) {
            for (int i = 0; i < inGates.length; i++) {
                inValues[i] = inGates[i].calc(); // Calculate the result of each input gate and store it in inValues.
            }
        }

        return func(inValues); // Call the abstract func() method to perform the gate operation.
    }

    protected abstract boolean func(boolean[] inValues) throws CircuitException;

    public abstract String getName();

    public abstract Gate simplify();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(getName());

        if (inGates != null) {
            sb.append("[");

            for (int i = 0; i < inGates.length; i++) {
                sb.append(inGates[i]);

                if (i < inGates.length - 1) {
                    sb.append(", ");
                }
            }

            sb.append("]");
        }

        return sb.toString();
    }
}
