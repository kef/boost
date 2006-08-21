package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.exception.NotImplementedException;

// FIX SC600 BREADCRUMB Rename DataDemoTest to DataDemoTestCase.  Rename to DataAtomScenarioTest.
// FIX SC600 BREADCRUMB Complete this.
public class DataAtomTestCase extends PrimordialTestCase implements DataAtomTester {
    public void checkAtom(Object field1) {
        throw new NotImplementedException();
    }

    public void checkAtom(Object field1, Object field2) {
        Object[] fields = {field1, field2};
        checkAtom(fields);
    }

    public void checkAtom(Object field1, Object field2, Object field3) {
        throw new NotImplementedException();
    }

    public void checkAtom(Object field1, Object field2, Object field3, Object field4) {
        throw new NotImplementedException();
    }

    public void checkAtom(Object[] fields) {
        // FIX SC600 Use field name to obtain bean property name.
        // FIX SC600 BREADCRUMB Complete.
    }

    protected final void setUp() throws Exception {
        // FIX SC600 Populate each of the subclasses fields using TriangulationProvider.
        // FIX SC600 Use the populated fields values to correlate with checkAtom(...) parameters.
        // FIX SC600 Perform and fail on fields not being Data/Immutable.
    }
}
