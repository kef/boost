package au.net.netstorm.boost.nursery.eight.legged.spider.injection.types;

import java.lang.reflect.Type;

public interface InjectionTypeBuilder {
    // FIX 2394 genericize
    InjectionType build(Type type);
}
