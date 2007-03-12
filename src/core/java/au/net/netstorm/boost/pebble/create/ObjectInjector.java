package au.net.netstorm.boost.pebble.create;

public final class ObjectInjector implements Injector {
    private final Injector creatorInjector;
    private final Injector dependencyInjector;

    public ObjectInjector(Injector creatorInjector, Injector dependencyInjector) {
        this.creatorInjector = creatorInjector;
        this.dependencyInjector = dependencyInjector;
    }

    public void inject(Object ref) {
        creatorInjector.inject(ref);
        dependencyInjector.inject(ref);
    }
}
