package au.net.netstorm.boost.pebble.create.inject;

public final class DependencyInjector implements Injector {
    // FIX 1715 Need to make this find all non-"newer" fields and then inject
    // them with their default dependencies. 
    public void inject(Object object) {
    }
}
