package circuits;

public class FalseGate extends Gate {
    private static FalseGate instance = null;

    private FalseGate() {
        super(null); // FalseGate doesn't have other gates as input, so we send null
    }

    public static Gate instance() {
        if (instance == null) {
            instance = new FalseGate(); // If the user calls this method for the first time, create a new instance of FalseGate and update the instance field
        }
        return instance; // If the user has already used this method, simply return the existing instance
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        return false; // The function of FalseGate always returns false
    }

    @Override
    public String getName() {
        return "F"; // Return the name of the gate as "F"
    }

    @Override
    public Gate simplify() {
        return instance(); // FalseGate simplifies to itself, so return the existing instance
    }
}
