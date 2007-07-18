package au.net.netstorm.boost.nursery.edgify;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import junit.framework.Assert;

public final class DefaultEdgeConstructorChecker implements EdgeChecker {
    private static final List CONSTRUCTOR_MODIFIER_EXCEPTIONS = new ArrayList();
    private ClassMaster classer = new DefaultClassMaster();

    public void check(Class edgeClass) {
        Constructor edgeConstructor = checkAndGetSingleConstructor(edgeClass);
        checkPackagePrivateConstructor(edgeClass, edgeConstructor);
    }

    private Constructor checkAndGetSingleConstructor(Class edgeClass) {
        Constructor[] constructors = edgeClass.getDeclaredConstructors();
        Assert.assertEquals("Edge classes should contain only one constructor.", 1, constructors.length);
        return constructors[0];
    }

    private void checkPackagePrivateConstructor(Class edgeClass, Constructor constructor) {
        if (CONSTRUCTOR_MODIFIER_EXCEPTIONS.contains(edgeClass)) return;
        checkPackagePrivate(constructor, edgeClass);
    }

    private void checkPackagePrivate(Constructor constructor, Class edgeClass) {
        int modifiers = constructor.getModifiers();
        boolean packagePrivate = isPackagePrivate(modifiers);
        String simpleName = classer.getShortName(edgeClass);
        Assert.assertTrue(simpleName + " does not contain a package private constructor.", packagePrivate);
    }

    private boolean isPackagePrivate(int modifiers) {
        if (Modifier.isPublic(modifiers)) return false;
        if (Modifier.isProtected(modifiers)) return false;
        return true;
    }
}
