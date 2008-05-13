package au.net.netstorm.boost.edge.guts;

import au.net.netstorm.boost.edge.testdata.java.util.BadList;
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

    // FIX 2328 drive up negative case for instance edge
    public void testValidateEdgeFailure() {
//        try {
            validator.validateEdge(BadList.class, java.util.List.class);
//        } catch (IllegalArgumentException expected) {}
    }
}
