package au.net.netstorm.boost.demo.pebble.fixtures;

// FIX 1665 Use naming convention like (DefaultRob, Rob).
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
