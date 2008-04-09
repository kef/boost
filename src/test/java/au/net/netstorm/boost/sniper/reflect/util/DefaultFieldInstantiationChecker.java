package au.net.netstorm.boost.sniper.reflect.util;

import junit.framework.Assert;

public final class DefaultFieldInstantiationChecker implements FieldInstantiationChecker {
    private FieldTestUtil fieldTestUtil = new DefaultFieldTestUtil();

    public void check(Object ref, String fieldName, Class expectedImplClass) {
        Object o = fieldTestUtil.getInstance(ref, fieldName);
        Assert.assertNotNull("You must create an instance of " + expectedImplClass + " for " + fieldName, o);
        Assert.assertSame(o.getClass(), expectedImplClass);
    }
}
