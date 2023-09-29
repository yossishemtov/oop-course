package circuits;

public class NotGate extends Gate
{

	public NotGate(Gate in)
	{
		super(new Gate[1]); // send to super-class constructor empty array of Gate in length 1
		inGates[0]=in; // assign in to be the Gate in the array of Gate in length 1
	}

	@Override
	protected boolean func(boolean[] inValues) throws CircuitException {
		return !(inGates[0].calc()); // returen the result of inGates[0] and NOT on the result.
	}

	@Override
	public String getName() {return "NOT";}

	@Override
    public Gate simplify() {
        Gate simplifiedinGates = inGates[0].simplify();

        if (simplifiedinGates instanceof FalseGate) {
            return TrueGate.instance();
        } else if (simplifiedinGates instanceof TrueGate) {
            return FalseGate.instance();
        } else if (simplifiedinGates instanceof NotGate) {
            return simplifiedinGates;
        } else {
            return this;
        }
    }
}
