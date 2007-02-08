package au.net.netstorm.boost.demo.pebble.fixtures;

import au.net.netstorm.boost.nursery.pebble.create.Ned;
import au.net.netstorm.boost.nursery.pebble.create.Ted;

public final class ConstructorInjection {
    private TedNewer tedCreator;
    private NedNewer nedCreator;

    public ConstructorInjection(TedNewer tedCreator, NedNewer nedCreator) {
        this.tedCreator = tedCreator;
        this.nedCreator = nedCreator;
    }

    public void doStuff() {
        Ted ted = tedCreator.create();
        doStuffWithTed(ted);
        Ned ned = nedCreator.create();
        doStuffWithNed(ned);
    }

    private void doStuffWithNed(Ned ned) {
    }

    private void doStuffWithTed(Ted ted) {
    }
}