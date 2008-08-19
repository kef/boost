package au.net.netstorm.boost.nursery.immutable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import au.net.netstorm.boost.bullet.mirror.ClassMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultClassMaster;
import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.tostring.ToStringMaster;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.gunge.tostring.IndentingToStringMaster;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX 2130 Migrate to Layer.
public class DataLayer extends Primordial implements Layer {
    private final Interface iface;
    private final FieldValueSpec[] fields;
    private final DataInvocationHandlerValidator validator = new DefaultDataInvocationHandlerValidator();

    public DataLayer(Interface iface, FieldValueSpec[] fields) {
        validator.check(fields, iface);
        this.iface = iface;
        this.fields = fields;
    }

    public Object invoke(Method method, Object[] params) {
        if (method.getDeclaringClass() == Object.class) return object(method, params);
        return values(method);
    }

    private Object object(Method method, Object[] params) {
        if (is("equals", method)) return calculateEquals(params[0]);
        if (is("hashCode", method)) return calculateHashCode();
        if (is("toString", method)) return calculateToString();
        // FIX 2130 What about wait()/notify... (here comes the Onion).
        throw new UnsupportedOperationException("" + method);
    }

    private boolean is(String match, Method method) {
        String name = method.getName();
        return name.equals(match);
    }

    private Object values(Method method) {
        String name = method.getName();
        for (FieldValueSpec field : fields) {
            if (same(name, field)) return field.getValue();
        }
        throw new UnsupportedOperationException("" + method);
    }

    private boolean same(String match, FieldValueSpec field) {
        String name = field.getName();
        return match.equals(name);
    }

    // FIX 2130 Move into separate classes.
    public Boolean calculateEquals(Object o) {
        if (o == null) return Boolean.FALSE;
        if (!Proxy.isProxyClass(o.getClass())) return Boolean.FALSE;
        InvocationHandler handler = Proxy.getInvocationHandler(o);
        return Boolean.valueOf(equals(handler));
    }

    private String calculateToString() {
        Class type = iface.getType();
        ToStringMaster stringer = new IndentingToStringMaster();
        String string = stringer.formatFields(this, fields);
        ClassMaster classer = new DefaultClassMaster();
        return classer.getShortName(type) + " proxied by " + string;
    }

    private Integer calculateHashCode() {
        int hashCode = iface.hashCode();
        for (int i = 0; i < fields.length; i++) {
            hashCode = hashCode + 31 * fields[i].hashCode();
        }
        return new Integer(hashCode);
    }
}
