package au.net.netstorm.boost.test.automock;

import au.net.netstorm.boost.test.field.BoostField;
import au.net.netstorm.boost.test.random.EverythingRandomProvider;
import au.net.netstorm.boost.test.random.RandomProvider;

public final class ArrayRandomizer implements Randomizer {
    private RandomProvider randomProvider = new EverythingRandomProvider();

    public void randomize(BoostField[] fields) {
        for (int i = 0; i < fields.length; i++) {
            Class type = fields[i].getType();
            randomProvider.get(type);
        }
    }
}
