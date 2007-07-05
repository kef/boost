package au.net.netstorm.boost.test.random;

public interface RandomProvider {
    // FIX BREADCRUMB 2076 Use spider provider.
    Object get(Class type);
}
