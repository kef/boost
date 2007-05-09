package au.net.netstorm.boost.spider.inject.newer.field;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeField;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeField;
import au.net.netstorm.boost.spider.inject.newer.core.DoesNotImplementNewerException;
import au.net.netstorm.boost.spider.inject.newer.core.Newer;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

// FIX 1665 Do we use this any more.  Yes.  Rename and tidy up

// DEBT ClassDataAbstractionCoupling {
public final class DefaultNewerFieldInspector implements NewerFieldInspector {
    private static final Interface NEWER_MARKER = new DefaultInterface(Newer.class);
    // FIX 1665 Should be passed in via the constructor.
    private final EdgeField edgeField = new DefaultEdgeField();

    // FIX 1665 Barf if NewerInterface does not contain CLASS_TO_NU field?
    public boolean isNewer(Object ref, Field field) {
        if (isFinal(field)) return false;
        if (!isNull(ref, field)) return false;
        if (!nameStartsWith(field, "new")) return false;
        checkImplementsMarker(field);
        return true;
    }

    private void checkImplementsMarker(Field field) {
        Class typeClass = field.getType();
        Interface type = new DefaultInterface(typeClass);
        if (!type.is(NEWER_MARKER)) {
            throw new DoesNotImplementNewerException(type, NEWER_MARKER);
        }
    }

    private boolean nameStartsWith(Field field, String prefix) {
        String name = field.getName();
        return name.startsWith(prefix);
    }

    private boolean isNull(Object ref, Field field) {
        field.setAccessible(true);
        Object value = edgeField.get(field, ref);
        return value == null;
    }

    private boolean isFinal(Field field) {
        int modifiers = field.getModifiers();
        return Modifier.isFinal(modifiers);
    }
}
// } DEBT ClassDataAbstractionCoupling