package circuits;

public class VarGate extends Gate {
    private String name;
    private boolean[] value = null; // Use a boolean array to store the value (single boolean)

    public VarGate(String name) {
        super(null); // VarGate doesn't have any input gates, so we pass null to the super-class constructor
        this.name = name;
    }

    public void setVal(boolean value) {
        if (this.value == null) // If the value was not set previously
            this.value = new boolean[1]; // Allocate memory for the boolean array
        this.value[0] = value; // Assign the given value to value[0]
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        if (value == null) // If the value is null, it means the value of VarGate was not set yet
            throw new CircuitException(getName() + " has not been set yet.\n"); // Throw a CircuitException with an appropriate message
        return value[0]; // Return the value of the VarGate
    }

    @Override
    public String getName() {
        return "V" + name; // Return the name of the VarGate with "V" prefix
    }

    @Override
    public Gate simplify() {
        if (value == null) // If the value is not set, the VarGate cannot be simplified further
            return this; // Return the current instance
        else if (value[0] == true) // If the value is true, return TrueGate instance
            return TrueGate.instance();
        else // If the value is false, return FalseGate instance
            return FalseGate.instance();
    }

}
