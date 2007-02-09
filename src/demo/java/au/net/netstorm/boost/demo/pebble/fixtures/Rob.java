package au.net.netstorm.boost.demo.pebble.fixtures;

public final class Rob {
    private NewDefaultBob newDefaultBob;
    private Bob bob;

    public void doStuff() {
        bob = newDefaultBob.create("I am your friend.");
    }

    public Bob getBob() {
        return bob;
    }
}