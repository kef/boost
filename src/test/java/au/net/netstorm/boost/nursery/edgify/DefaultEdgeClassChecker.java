package au.net.netstorm.boost.nursery.edgify;

import junit.framework.Assert;

import java.lang.reflect.Modifier;

public final class DefaultEdgeClassChecker implements EdgeChecker {
    public void check(Class edgeClass) {
        int classModifiers = edgeClass.getModifiers();
        boolean isPublicAndFinal = isPublicAndFinal(classModifiers);
        Assert.assertTrue("The class " + edgeClass.getName() + " should be public and final.", isPublicAndFinal);
    }

    private boolean isPublicAndFinal(int classModifiers) {
        return Modifier.isPublic(classModifiers) && Modifier.isFinal(classModifiers);
    }
}
