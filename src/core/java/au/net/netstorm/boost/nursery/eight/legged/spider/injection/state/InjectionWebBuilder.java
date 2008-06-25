package au.net.netstorm.boost.nursery.eight.legged.spider.injection.state;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.Bindings;
import au.net.netstorm.boost.nursery.eight.legged.spider.factory.core.Factories;

public interface InjectionWebBuilder {
    InjectionWeb build(Bindings bindings, Factories factories);
}
