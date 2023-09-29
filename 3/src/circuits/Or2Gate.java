package circuits;

public class Or2Gate extends OrGate
{

	public Or2Gate(Gate g1 , Gate g2) {
		// Call the constructor of the superclass (OrGate) with an array containing g1 and g2 as input gates.
		super(new Gate[2]);  
		inGates[0]=g1; 
		inGates[1]=g2;
	}

}
