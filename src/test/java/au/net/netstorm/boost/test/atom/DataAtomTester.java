package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface DataAtomTester {
    void checkAtom(FieldSpec fs1);

    void checkAtom(FieldSpec fs1, FieldSpec fs2);

    void checkAtom(FieldSpec fs1, FieldSpec fs2, FieldSpec fs3);

    void checkAtom(FieldSpec fs1, FieldSpec fs2, FieldSpec fs3, FieldSpec fs4);

    void checkAtom(FieldSpec fs1, FieldSpec fs2, FieldSpec fs3, FieldSpec fs4, FieldSpec fs5);

    void checkAtom(FieldSpec[] fieldSpecs);
}
