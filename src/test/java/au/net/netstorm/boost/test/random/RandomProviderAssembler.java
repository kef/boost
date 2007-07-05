package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.specific.SpecificProviderRegistry;

public interface RandomProviderAssembler {
    RandomProvider everything();

    RandomProvider everything(SpecificProviderRegistry registry);
}
