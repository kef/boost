package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface AtomStructureChecker {
    void checkStructure(Class cls, FieldSpec[] fields);
}
