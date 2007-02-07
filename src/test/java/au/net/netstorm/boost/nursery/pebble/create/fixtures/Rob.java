package au.net.netstorm.boost.nursery.pebble.create.fixtures;

public final class Rob {
    private BobCreator newBobCreator;
    public Bob bob;

    public void doStuff() {
        bob = newBobCreator.create("I am your friend.");
    }
}
