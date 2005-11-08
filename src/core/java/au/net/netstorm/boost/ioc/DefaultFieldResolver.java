package au.net.netstorm.boost.ioc;

import java.lang.reflect.Field;

import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.reflect.DefaultClassMaster;

// FIXME: SC509 Tidy this up.
public class DefaultFieldResolver implements FieldResolver {
    public void resolve(Object ref, FieldValueSpec fieldValueSpec) {
        validate(ref);
        doResolve(ref, fieldValueSpec);
    }

    private void doResolve(Object ref, FieldValueSpec fieldValueSpec) {
        String name = fieldValueSpec.getName();
        Object value = fieldValueSpec.getValue();
        Field field = getField(ref, name);
        // FIXME: SC502 Reinstate this check.
//        ensureNull(ref, field);
        setValue(ref, field, value);
    }

// FIXME: SC509  remove duplication.
//    private void ensureNull(Object ref, Field field) {
//        field.setAccessible(true);
//        Object value = doGet(field, ref);
//        if (value != null) throw new FieldAlreadyInitializedException();
//    }

//    private Object doGet(Field field, Object ref) {
//        try {
//            return field.get(ref);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//    }

    // FIXME: SC509 Test drive the message for bad type.
    private void setValue(Object ref, Field field, Object value) {
        try {
            doSetValue(ref, field, value);
        } catch (IllegalAccessException e) {
            throw new IocException(null, e);
        } catch (IllegalArgumentException e) {
            throw new IocException(makeBadTypeMessage(field, value), e);
        }
    }

    // FIXME: SC509 Is this message actually tested.  If not bollocks it.
    private String makeBadTypeMessage(Field field, Object value) {
        return "Field '" + field.getName() + "' of type " +
                getClassName(field.getType()) + " cannot be set with type " +
                getClassName(value.getClass());
    }

    private String getClassName(Class type) {
        // FIXME: SC509 Field for DCM.
        return new DefaultClassMaster().getShortName(type);
    }

    private void doSetValue(Object ref, Field field, Object value) throws IllegalAccessException {
        field.setAccessible(true);
        field.set(ref, value);
    }

    // FIXME: SC510 How about just a RuntimeNoSuchFieldException.  Bet the message isn't test driven either.
    private Field getField(Object ref, String name) {
        try {
            return ref.getClass().getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            throw new IocException("Field \"" + name + "\" does not exist in class " + ref.getClass(), e);
        }
    }

    private void validate(Object value) {
        if (value == null) throw new IllegalArgumentException();
    }
}
