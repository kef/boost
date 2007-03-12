package au.net.netstorm.boost.pebble.create;

public final class ObjectInjector implements Injector {
    private final Injector creatorInjector;
    private final Injector resolverInjector;

    public ObjectInjector(Injector creatorInjector, Injector resolverInjector) {
        this.creatorInjector = creatorInjector;
        this.resolverInjector = resolverInjector;
    }

    public void inject(Object ref) {
        creatorInjector.inject(ref);
        resolverInjector.inject(ref);
    }
}
