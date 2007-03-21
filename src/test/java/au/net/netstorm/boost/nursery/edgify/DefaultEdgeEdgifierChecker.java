package au.net.netstorm.boost.nursery.edgify;

import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import junit.framework.Assert;

public final class DefaultEdgeEdgifierChecker implements EdgeChecker {
    private static final String SUPPLIER = "Supplier";

    public void check(Class edgeClass) {
        if (!extendsDefaultEdgeSupplier(edgeClass)) return;
        checkEdgeClassIsASupplier(edgeClass);
    }

    private void checkEdgeClassIsASupplier(Class edgeClass) {
        String name = getName(edgeClass);
        boolean isSupplier = name.endsWith(SUPPLIER);
        Assert.assertTrue(name + " cannot extend DefaultEdgeSupplier.", isSupplier);
    }

    private boolean extendsDefaultEdgeSupplier(Class edgeClass) {
        Class superClass = edgeClass.getSuperclass();
        return superClass == DefaultEdgeSupplier.class;
    }

    private String getName(Class edgeClass) {
        ClassMaster classMaster = new DefaultClassMaster();
        return classMaster.getShortName(edgeClass);
    }
}
