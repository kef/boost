package au.net.netstorm.boost.test.atom;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Data;
import junit.framework.Assert;

final class ClassDataChecker implements DataChecker {
    private ClassTestChecker classChecker = new DefaultClassTestChecker();

    public void check(Class cls, FieldSpec[] fields) {
        checkNotInterface(cls);
        checkImplementsDataAndFinal(cls);
        checkSubclassOfPrimordial(cls);
    }

    private void checkNotInterface(Class cls) {
        if (!cls.isInterface()) return;
        fail("Data atoms must be a class not an interface.  The Data atom can implement interfaces.");
    }

    private void checkSubclassOfPrimordial(Class cls) {
        classChecker.checkSubclassOf(cls, Primordial.class);
    }

    private void checkImplementsDataAndFinal(Class cls) {
        classChecker.checkImplementsAndFinal(cls, Data.class);
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
