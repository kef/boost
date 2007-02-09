package au.net.netstorm.boost.demo.pebble.create;

public final class DefaultBob implements Bob {
    private NewHeadJob newHeadJob;

    public DefaultBob(String comment) {
    }

    public NewHeadJob getNewHeadJob() {
        return newHeadJob;
    }
}
