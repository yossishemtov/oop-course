package circuits;

import java.util.ArrayList;
import java.util.List;

public class AndGate extends Gate {
    public AndGate(Gate[] inGates) {
        super(inGates);
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        boolean result = true;
        for (boolean value : inValues) {
            result = result && value; // Perform logical AND operation on each input value
        }
        return result;
    }

    @Override
    public String getName() {
        return "AND";
    }

    @Override
    public Gate simplify() {
        List<Gate> chosenChildren = new ArrayList<>();

        // Iterate over the input gates to simplify them
        for (Gate inGate : inGates) {
            if (inGate instanceof FalseGate) {
                // If there is a FalseGate among the input gates, the result will always be false
                return FalseGate.instance();
            } else if (!(inGate.simplify() instanceof TrueGate)) {
                // If the simplified version of the input gate is not a TrueGate, add it to the chosenChildren list
                chosenChildren.add(inGate.simplify());
            }
        }

        if (chosenChildren.isEmpty()) {
            // If no gates were chosen for simplification, the result will always be true
            return TrueGate.instance();
        } else if (chosenChildren.size() == 1) {
            // If there is only one gate chosen for simplification, return that gate
            return chosenChildren.get(0);
        } else {
            // If there are multiple gates chosen for simplification, create a new AndGate with the simplified children
            Gate[] simplifiedChildren = chosenChildren.toArray(new Gate[0]);
            return new AndGate(simplifiedChildren);
        }
    }
}
