package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.test.atom.DataAtomTestCase;

// FIX SC600 Complete or remove.
public final class SimpleDataAtomDemoTest extends DataAtomTestCase {
    private String guitar;
    private BasicInterface basic;

    public void testAtom() {
        checkAtom(guitar, basic);
    }
}
