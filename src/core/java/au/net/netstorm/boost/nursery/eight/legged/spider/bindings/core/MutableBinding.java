package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factory;

public interface MutableBinding extends Binding {
    void setFactory(Factory factory);
    void makeSingleton();
}
