package au.net.netstorm.boost.demo.pebble.fixtures;

import au.net.netstorm.boost.nursery.pebble.create.Ned;
import au.net.netstorm.boost.nursery.pebble.create.Ted;

public final class ConstructorInjection {
    private TedCreator tedCreator;
    private NedCreator nedCreator;

    public ConstructorInjection(TedCreator tedCreator, NedCreator nedCreator) {
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