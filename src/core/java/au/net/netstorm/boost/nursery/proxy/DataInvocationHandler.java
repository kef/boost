package au.net.netstorm.boost.nursery.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import au.net.netstorm.boost.bullet.mirror.ClassMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultClassMaster;
import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.tostring.ToStringMaster;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.util.tostring.IndentingToStringMaster;

public class DataInvocationHandler extends Primordial implements InvocationHandler {
    private final Interface iFace;
    private final FieldValueSpec[] fields;
    private final DataInvocationHandlerValidator validator = new DefaultDataInvocationHandlerValidator();

    public DataInvocationHandler(Interface iFace, FieldValueSpec[] fields) {
        validator.check(fields, iFace);
        this.iFace = iFace;
        this.fields = fields;
    }

    public Object invoke(Object object, Method method, Object[] params) throws Throwable {
        if (method.getDeclaringClass() == Object.class) return objectMethods(method, params);
        return tryFields(method);
    }

    private Object objectMethods(Method method, Object[] params) {
        if (isEquals(method)) return calculateEquals(params[0]);
        if (isHashCode(method)) return calculateHashCode();
        if (isToString(method)) return doToString();
        throw new UnsupportedOperationException("" + method);
    }

    private boolean isEquals(Method method) {
        return method.getName().equals("equals");
    }

    private boolean isHashCode(Method method) {
        return method.getName().equals("hashCode");
    }

    private boolean isToString(Method method) {
        return method.getName().equals("toString");
    }

    public Boolean calculateEquals(Object o) {
        if (o == null) return Boolean.FALSE;
        if (!Proxy.isProxyClass(o.getClass())) return Boolean.FALSE;
        InvocationHandler handler = Proxy.getInvocationHandler(o);
        return Boolean.valueOf(equals(handler));
    }

    private String doToString() {
        Class type = iFace.getType();
        ToStringMaster stringer = new IndentingToStringMaster();
        String string = stringer.formatFields(this, fields);
        ClassMaster classer = new DefaultClassMaster();
        return classer.getShortName(type) + " proxied by " + string;
    }

    private Integer calculateHashCode() {
        int hashCode = iFace.hashCode();
        for (int i = 0; i < fields.length; i++) {
            hashCode = hashCode + 31 * fields[i].hashCode();
        }
        return new Integer(hashCode);
    }

    private Object tryFields(Method method) {
        String name = method.getName();
        for (int i = 0; i < fields.length; i++) {
            FieldValueSpec field = fields[i];
            if (name.equals(field.getName())) return field.getValue();
        }
        throw new UnsupportedOperationException("" + method);
    }
}
