package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.gunge.introspect.FieldSpec;

public interface AtomStructureChecker {
    void checkStructure(Class cls, FieldSpec[] fields);
}
