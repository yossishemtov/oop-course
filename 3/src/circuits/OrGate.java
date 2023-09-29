package circuits;

import java.util.List;
import java.util.ArrayList;

public class OrGate extends Gate
{

	public OrGate(Gate[] inGates) {super(inGates);}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException 
	{
		boolean result=inValues[0];
		for(int i=1;i<inValues.length;i++) // scan all input values.
			result=result || inValues[i]; // calculte reuslt OR inValues[i]
		return result;
	}

	@Override
	public String getName() {return "OR";}

	@Override
    public Gate simplify() {
        List<Gate> chosenChildren = new ArrayList<>(); // Create an empty list to store the simplified children of this current OrGate
        for (Gate gate : inGates) {
            Gate simplifiedGate = gate.simplify();
            if (simplifiedGate instanceof TrueGate) { // If the gate is a TrueGate, return a TrueGate instance
                return TrueGate.instance();
            } else if (!(simplifiedGate instanceof FalseGate)) { // If the simplified gate is not a FalseGate
                chosenChildren.add(simplifiedGate); // Add the simplified version of the gate to the list of chosen children
            }
        }
        if (chosenChildren.isEmpty()) { // If there are no children to simplify, return a FalseGate instance
            return FalseGate.instance();
        } else if (chosenChildren.size() == 1) { // If there is only one chosen child, return it
            return chosenChildren.get(0);
        } else { // If there are multiple chosen children, return an OrGate with the chosen children as input gates
            return new OrGate(chosenChildren.toArray(new Gate[0]));
        }
    }

}
