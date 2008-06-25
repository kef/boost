package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core;

import java.util.List;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;

public interface Bindings {
    void add(Binding binding);
    List<Binding> lookup(InjectionType type);
}
