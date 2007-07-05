package au.net.netstorm.boost.test.specific;

public interface SpecificProviderRegistry {

    boolean contains(Class type);

    // FIX 2076 This should be SpecificProvider.
    Object get(Class type);

    // FIX 2076 This is only used to prepare the registry.
    void add(Class type, SpecificProvider provider);
}
