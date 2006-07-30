package au.net.netstorm.boost.test.fixture;

import au.net.netstorm.boost.util.introspect.FieldSpec;

public interface DataTestChecker {
    void checkIsData(Class cls, FieldSpec[] fields);

    void checkIsData(Class cls, FieldSpec[] fields, TriangulationProvider additional);
}
