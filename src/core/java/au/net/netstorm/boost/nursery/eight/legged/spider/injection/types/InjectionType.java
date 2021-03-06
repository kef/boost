package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

public interface InjectionType<T> {
    InjectionType<T> raw();
    // FIX 2394 placeholder not going to be implemented yet
    InjectionType<?>[] parameters();
    Class<T> rawClass();
    boolean isInterface();
}
