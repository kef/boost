package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

// FIX 2394 MAG Need to understand this foo.
// FIX 2394 push generic InjectionType through codebase.
public interface InjectionType<T> {
    InjectionType<T> raw();
    // FIX 2394 placeholder not going to be implemented yet
    InjectionType<?>[] parameters();
    Class<T> rawClass();
    boolean isInterface();
}
