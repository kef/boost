package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;

public interface RandomProviderAssembler {
    RandomProvider everything(SpecificProviderRegistry registry);
}
