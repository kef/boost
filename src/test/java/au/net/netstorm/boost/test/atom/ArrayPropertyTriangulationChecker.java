package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

final class ArrayPropertyTriangulationChecker implements TriangulationChecker {
    private InstanceHelper instanceHelper = new DefaultInstanceHelper();
    private PropertyAccessor propertyAccessor = new DefaultPropertyAccessor();

    // FIX SC600 Hard fail on Arrays containing arrays.  We do not support them.
    public void check(Class cls, Object[] parameters, FieldSpec candidate, int position) {
        Object instance = instanceHelper.getInstance(cls, parameters);
        Object returnValue = propertyAccessor.invoke(instance, candidate);
        // FIX SC600 Must be different references.
        // FIX SC600 Contents must be the same.
        // FIX SC600 BREADCRUMB Finish this off.
    }
}
