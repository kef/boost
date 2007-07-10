package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.spider.core.Provider;

// FIX 2076 Split this interface.

// FIX 2076 Rename to Specifics.
public interface SpecificProviderRegistry extends Provider {

    boolean canProvide(Class type);

    void add(Class type, SpecificProvider provider);
}
