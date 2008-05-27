package au.net.netstorm.boost.nursery.eight.legged.spider.rules.core;

import au.net.netstorm.boost.nursery.eight.legged.spider.provider.factory.Factory;

// FIX 2328 a rule for obtaining a mapping from an injection site to an injection
public interface Rule {
    Factory getFactory();
}
