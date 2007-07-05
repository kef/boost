package au.net.netstorm.boost.test.specific;

public interface SpecificProviderRegistry {

    boolean contains(Class type);

    Object get(Class type);

    void add(Class type, SpecificProvider provider);
}
