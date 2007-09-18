package au.net.netstorm.boost.nursery.proxy;

import java.lang.reflect.Method;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.type.Interface;

public class DefaultDataInvocationHandlerValidator implements DataInvocationHandlerValidator {

    public void check(FieldValueSpec[] fields, Interface iFace) {
        Method[] methods = iFace.getType().getMethods();
        for (int i = 0; i < methods.length; i++) {
            valid(methods[i], fields);
        }
        sameNumber(methods, fields);
    }

    private void valid(Method method, FieldValueSpec[] fields) {
        valid(method);
        hasField(method, fields);
    }

    private void valid(Method method) {
        noParams(method);
        noPrimatives(method);
    }

    private void noPrimatives(Method method) {
        Class returnType = method.getReturnType();
        if (returnType.isPrimitive())
            throw new IllegalArgumentException("Primitives not supported " + method);
    }

    private void noParams(Method method) {
        Class[] params = method.getParameterTypes();
        if (params.length != 0)
            throw new IllegalArgumentException("Params not allowed " + method);
    }

    private void hasField(Method method, FieldValueSpec[] fields) {
        for (int j = 0; j < fields.length; j++) {
            if (equal(fields[j], method)) return;
        }
        throw new IllegalArgumentException("No field for method " + method);
    }

    private boolean equal(FieldValueSpec field, Method method) {
        boolean namesEqual = namesEqual(field, method);
        boolean typesEqual = typesEqual(method, field);
        return namesEqual && typesEqual;
    }

    private boolean namesEqual(FieldValueSpec field, Method method) {
        String methodName = method.getName();
        String fieldName = field.getName();
        return fieldName.equals(methodName);
    }

    private boolean typesEqual(Method method, FieldValueSpec field) {
        Class returnType = method.getReturnType();
        Object fieldValue = field.getValue();
        Class fieldType = fieldValue.getClass();
        return returnType.isAssignableFrom(fieldType);
    }

    private void sameNumber(Method[] methods, FieldValueSpec[] fields) {
        int numMethods = methods.length;
        int numFields = fields.length;
        if (numMethods != numFields) throw new IllegalArgumentException("Number of methods(" + numMethods
                + ") and fields(" + numFields + ") differ");
    }
}