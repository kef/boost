package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import java.lang.reflect.Type;

// FIX 2394 genericize
public interface InjectionTypeBuilder {
    <T> InjectionType<T> build(Class<T> type);
    InjectionType build(Type type);
}
