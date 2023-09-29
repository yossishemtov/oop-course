package circuits;

public class TrueGate extends Gate {
    
    private static final TrueGate instance = new TrueGate();

    private TrueGate() {
        super(null); // True gate doesn't have any input gates, so we pass null to the super-class constructor
    }

    public static Gate instance() {
        return instance; // Returns the single instance of TrueGate
    }

    @Override
    protected boolean func(boolean[] inValues) throws CircuitException {
        return true; // The function of TrueGate always returns true
    }

    @Override
    public String getName() {
        return "T"; // Returns the name of the gate as "T"
    }

    @Override
    public Gate simplify() {
        return instance(); // TrueGate is already in its simplest form, so it returns itself
    }
}
