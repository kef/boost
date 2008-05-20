package au.net.netstorm.boost.nursery.eight.legged.spider.provider.core;

import au.net.netstorm.boost.gunge.type.UnresolvedInstance;
import au.net.netstorm.boost.gunge.type.ResolvedInstance;
import au.net.netstorm.boost.gunge.type.ReferenceMaster;
import au.net.netstorm.boost.gunge.type.DefaultReferenceMaster;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.spider.instantiate.Instantiator;
import au.net.netstorm.boost.spider.instantiate.SingleConstructorBasedInjectionInstantiator;

// FIX 2328 just giving some concepts a name and trying to map them to existing functionality
public final class MultiProvider implements Provider {
    private final ReferenceMaster references = new DefaultReferenceMaster();
    private final Instantiator instantiator = new SingleConstructorBasedInjectionInstantiator();
    private final Implementation impl;

    public MultiProvider(Implementation impl) {
        this.impl = impl;
    }

    public UnresolvedInstance nu(ResolvedInstance... args) {
        Object[] resolved = references.resolve(args);
        return instantiator.instantiate(impl, resolved);
    }
}
