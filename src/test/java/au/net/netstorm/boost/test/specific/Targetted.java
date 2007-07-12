package au.net.netstorm.boost.test.specific;

import au.net.netstorm.boost.test.core.Provider;

// FIX 2076 Split this interface.
public interface Targetted extends Provider {

    // FIX 2076 This should take an Interface
    void add(Class type, TargettedProvider provider);
}
