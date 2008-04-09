package au.net.netstorm.boost.sniper.atom;

import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.sniper.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.sniper.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.util.introspect.FieldSpec;
import au.net.netstorm.boost.util.type.Interface;
import junit.framework.Assert;

final class DefaultClassChecker implements ClassChecker {
    private ClassTestChecker classChecker = new DefaultClassTestChecker();

    public void check(Class cls, FieldSpec[] fields, Interface type) {
        checkNotInterface(cls);
        checkImplementsDataAndFinal(type, cls);
        checkSubclassOfPrimordial(cls);
    }

    private void checkNotInterface(Class cls) {
        if (!cls.isInterface()) return;
        fail("Data atoms must be a class not an interface.  The Data atom can implement interfaces.");
    }

    private void checkSubclassOfPrimordial(Class cls) {
        classChecker.checkSubclassOf(cls, Primordial.class);
    }

    private void checkImplementsDataAndFinal(Interface type, Class cls) {
        classChecker.checkImplementsAndFinal(type, cls);
    }

    private void fail(String msg) {
        Assert.fail(msg);
    }
}
