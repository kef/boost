package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import java.lang.reflect.Constructor;

public interface InjectionType {
    InjectionType raw();
    // FIX 2394 placeholder not going to be implemented yet
    InjectionType[] parameters();
    Class<?> rawClass();

    Constructor<?> getConstructor();
}
