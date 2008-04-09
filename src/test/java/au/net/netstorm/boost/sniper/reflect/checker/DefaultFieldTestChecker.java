package au.net.netstorm.boost.sniper.reflect.checker;

import java.lang.reflect.Field;
import au.net.netstorm.boost.sniper.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.sniper.reflect.util.FieldTestUtil;
import junit.framework.Assert;

public final class DefaultFieldTestChecker implements FieldTestChecker {
    private final FieldTestUtil fielderUtil = new DefaultFieldTestUtil();
    private final ModifierTestChecker modifiers = new DefaultModifierTestChecker();

    public void checkPrivateFinalInstanceField(Class type, String fieldName) {
        Field declared = fielderUtil.get(type, fieldName);
        modifiers.checkPrivateFinalInstance(declared);
    }

    public void checkInstanceType(Class expectedType, Object ref, String fieldName) {
        Object value = fielderUtil.getInstance(ref, fieldName);
        Class type = value.getClass();
        Assert.assertEquals(expectedType, type);
    }
}
