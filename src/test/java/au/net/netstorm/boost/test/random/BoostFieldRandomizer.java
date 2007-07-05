package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.field.BoostField;

public final class BoostFieldRandomizer implements Randomizer {
    private RandomProvider randomProvider;

    public BoostFieldRandomizer(RandomProvider randomProvider) {
        this.randomProvider = randomProvider;
    }

    public void randomize(BoostField[] fields) {
        for (int i = 0; i < fields.length; i++) {
            randomize(fields[i]);
        }
    }

    private void randomize(BoostField field) {
        Class cls = field.getType();
        Object random = randomProvider.get(cls);
        field.set(random);
    }
}
