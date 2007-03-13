package au.net.netstorm.boost.demo.pebble.newer;

final class Rob {
    private NewDefaultBob newDefaultBob;
    private Bob bob;

    public void checkNewerHasBeenPopulated() {
        bob = newDefaultBob.create("I am your friend.");
    }

    public Bob getBob() {
        return bob;
    }
}