package au.net.netstorm.boost.sniper.atom;

// FIX SC600 Complete combos.
public interface DataAtomTester {
    void checkAtom(Object field1);

    void checkAtom(Object field1, Object field2);

    void checkAtom(Object field1, Object field2, Object field3);

    void checkAtom(Object field1, Object field2, Object field3, Object field4);

    void checkAtom(Object[] fields);
}
