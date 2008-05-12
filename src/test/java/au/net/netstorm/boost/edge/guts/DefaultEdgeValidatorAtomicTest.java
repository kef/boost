package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.testdata.java.lang.ClassStatic;
import au.net.netstorm.boost.edge.testdata.java.util.List;
import au.net.netstorm.boost.sniper.core.LifecycleTestCase;
import au.net.netstorm.boost.sniper.marker.HasFixtures;
import au.net.netstorm.boost.sniper.marker.InjectableSubject;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.sniper.marker.LazyFields;

public final class DefaultEdgeValidatorAtomicTest extends LifecycleTestCase implements HasFixtures, InjectableSubject, InjectableTest, LazyFields {
    private EdgeValidator validator;

    public void setUpFixtures() {
        validator = new DefaultEdgeValidator();
    }

    // FIX 2328 drive up instance edge validation
    public void testValidateEdge() {
        validator.validateEdge(List.class, java.util.List.class);

    }

    // FIX 2328 drive up static edge validation
    public void testValidateStaticEdge() {
        validator.validateEdge(ClassStatic.class, Class.class);
    }
}
