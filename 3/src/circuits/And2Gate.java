package circuits;

public class And2Gate extends AndGate
{

	public And2Gate(Gate g1,Gate g2) 
	{
		super(new Gate[2]); // assign the inGates to be empty array of Gate in lenth 2
		inGates[0]=g1; //assign the inputGate g1 g2 into the arry of inputGates inGates.
		inGates[1]=g2;
	}
}
