package au.net.netstorm.boost.nursery.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.reflect.ClassMaster;
import au.net.netstorm.boost.reflect.DefaultClassMaster;
import au.net.netstorm.boost.util.introspect.FieldValueSpec;
import au.net.netstorm.boost.util.tostring.IndentingToStringMaster;
import au.net.netstorm.boost.util.tostring.ToStringMaster;
import au.net.netstorm.boost.util.type.Interface;

public class GetterInvocationHandler extends Primordial implements InvocationHandler {
    private final Interface iFace;
    private final FieldValueSpec[] fields;

    public GetterInvocationHandler(Interface iFace, FieldValueSpec[] fields) {
        // SUGGEST: Validate fields are in interface???
        this.iFace = iFace;
        this.fields = fields;
    }

    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        Object result = nullTryGetter(method);
        if (result != null) return result;
        return objectMethods(method, params);
    }

    private Object nullTryGetter(Method method) {
        String name = method.getName();
        if (isGetter(method)) return nullMatchingField(name);
        return null;
    }

    private boolean isGetter(Method method) {
        String name = method.getName();
        Class[] params = method.getParameterTypes();
        Class returnType = method.getReturnType();
        boolean nameOk = name.startsWith("get") || name.startsWith("is");
        return nameOk && !returnType.equals(void.class) && noArgs(params);
    }

    private Object nullMatchingField(String methodName) {
        String lowerMethodName = methodName.toLowerCase();
        for (int i = 0; i < fields.length; i++) {
            FieldValueSpec field = fields[i];
            if (namesMatch(field, lowerMethodName)) return field.getValue();
        }
        return null;
    }

    private boolean namesMatch(FieldValueSpec field, String lowerMethodName) {
        String name = field.getName();
        String lowerFieldName = name.toLowerCase();
        if (lowerMethodName.endsWith(lowerFieldName)) return true;
        return false;
    }

    private Object objectMethods(Method method, Object[] params) {
        if (isEquals(method, params)) return calculateEquals(params[0]);
        if (isHashCode(method, params)) return calculateHashCode();
        if (isToString(method, params)) return doToString();
        throw new UnsupportedOperationException("" + method);
    }

    private boolean isEquals(Method method, Object[] objects) {
        return method.getName().equals("equals") && objects.length == 1;
    }

    private boolean isHashCode(Method method, Object[] objects) {
        return method.getName().equals("hashCode") && noArgs(objects);
    }

    private boolean isToString(Method method, Object[] objects) {
        return method.getName().equals("toString") && noArgs(objects);
    }

    public Boolean calculateEquals(Object o) {
        if (o == null) return Boolean.FALSE;
        if (!Proxy.isProxyClass(o.getClass())) return Boolean.FALSE;
        InvocationHandler handler = Proxy.getInvocationHandler(o);
        return Boolean.valueOf(equals(handler));
    }

    private Integer calculateHashCode() {
        int hashCode = iFace.hashCode();
        for (int i = 0; i < fields.length; i++) {
            hashCode = hashCode + 31 * fields[i].hashCode();
        }
        return new Integer(hashCode);
    }

    private String doToString() {
        Class type = iFace.getType();
        ToStringMaster stringer = new IndentingToStringMaster();
        String string = stringer.formatFields(this, fields);
        ClassMaster classer = new DefaultClassMaster();
        return classer.getShortName(type) + " proxied by " + string;
    }

    private boolean noArgs(Object[] objects) {
        return objects == null || objects.length == 0;
    }
}
