package shop;

import java.util.List;
import java.util.ArrayList;

/**
 * Represents a music shop that manages a collection of instruments.
 */
public class Shop {
    private List<Instrument> listInstrument = new ArrayList<>();

    /**
     * Adds an instrument to the shop.
     *
     * @param i The instrument to be added.
     */
    public void add(Instrument i) {
        listInstrument.add(listInstrument.size(), i);
    }

    /**
     * Retrieves an instrument from the shop based on its serial number.
     *
     * @param serial The serial number of the instrument.
     * @return The instrument with the specified serial number, or null if not found.
     */
    public Instrument get(int serial) {
        for (Instrument i : listInstrument)
            if (i.getSerial() == serial)
                return i;
        return null;
    }

    /**
     * Retrieves a list of all serial numbers of instruments in the shop.
     *
     * @return A list of all serial numbers.
     */
    public List<Integer> allSerials() {
        List<Integer> serials = new ArrayList<>();
        for (Instrument i : listInstrument)
            serials.add(i.getSerial());
        return serials;
    }

    /**
     * Retrieves a list of serial numbers of guitars of a specific type in the shop.
     *
     * @param t The type of guitar.
     * @return A list of serial numbers of guitars of the specified type.
     */
    public List<Integer> guitarsOfType(Type t) {
        List<Integer> serials = new ArrayList<>();
        for (Instrument i : listInstrument)
            if (i instanceof Guitar)
                if (((Guitar) i).getType() == t)
                    serials.add(i.getSerial());
        return serials;
    }

    /**
     * Sells an instrument from the shop based on its serial number.
     *
     * @param serial The serial number of the instrument to be sold.
     * @throws MusicShopException If the instrument is not found or it's the last guitar of its type in the shop.
     */
    public void sell(int serial) throws MusicShopException {
        Instrument inst = get(serial);
        if (inst == null)
            throw new MusicShopException("no such Instrument");
        if (inst instanceof Guitar)
            if ((guitarsOfType(Type.ACOUSTIC).size() + guitarsOfType(Type.CLASSICAL).size() + guitarsOfType(Type.ELECTRIC).size()) == 1)
                throw new MusicShopException("last Guitar");
        listInstrument.remove(inst);
    }

    /**
     * Sells multiple instruments from the shop based on their serial numbers.
     *
     * @param serials An array of serial numbers of instruments to be sold.
     * @return The number of instruments successfully sold.
     */
    public int sellAll(int[] serials) {
        int count = 0;
        for (int i = 0; i < serials.length; i++) {
            try {
                sell(serials[i]);
            } catch (MusicShopException e) {
                count++;
            }
        }
        return count;
    }
}
