package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.test.core.BoooostCase;

// FIX SC600 BREADCRUMB Rename DataDemoTest to DataDemoTestCase.  Rename to DataAtomScenarioTest.

// FIX SC600 BREADCRUMB Complete this.
public class DataAtomTestCase extends BoooostCase implements DataAtomTester {

    protected final void gearup() {
        // FIX SC600 BREADCRUMB Delegate to populate fields using getDeclaredFields() which excludes inherited ones :-)
        // FIX SC600 Populate each of the subclasses fields using TriangulationProvider.
        // FIX SC600 Use the populated fields values to correlate with checkAtom(...) parameters.
        // FIX SC600 Perform and fail on fields not being Data/Immutable.
    }

    public void checkAtom(Object field1) {
        Object[] fields = {field1};
        checkAtom(fields);
    }

    public void checkAtom(Object field1, Object field2) {
        Object[] fields = {field1, field2};
        checkAtom(fields);
    }

    public void checkAtom(Object field1, Object field2, Object field3) {
        Object[] fields = {field1, field2, field3};
        checkAtom(fields);
    }

    public void checkAtom(Object field1, Object field2, Object field3, Object field4) {
        Object[] fields = {field1, field2, field3, field4};
        checkAtom(fields);
    }

    public void checkAtom(Object[] fields) {
        // FIX SC600 BREADCRUMB DELEGATE To SUPPORTING DUDE.
        // FIX SC600 Use field name to obtain bean property name.
        // FIX SC600 BREADCRUMB Complete.
    }
}
