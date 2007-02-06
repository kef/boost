package au.net.netstorm.boost.nursery.pebble.create.fixtures;

public final class ConstructorInjection {
    // FIX 1665 Nicer names.
    // FIX 1665 Move these out of here.
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