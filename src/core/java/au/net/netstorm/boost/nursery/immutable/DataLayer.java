package au.net.netstorm.boost.nursery.immutable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import au.net.netstorm.boost.bullet.mirror.ClassMaster;
import au.net.netstorm.boost.bullet.mirror.DefaultClassMaster;
import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.gunge.equals.ArraysEqualsMaster;
import au.net.netstorm.boost.gunge.introspect.FieldValueSpec;
import au.net.netstorm.boost.gunge.tostring.ToStringMaster;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.nursery.gunge.equals.DefaultArraysEqualsMaster;
import au.net.netstorm.boost.nursery.gunge.tostring.IndentingToStringMaster;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;
import au.net.netstorm.boost.spider.onion.core.Layered;

// FIX 2130 Move into separate classes.

// FIX 2130 Migrate to Layer.
public class DataLayer extends Primordial implements Layer {
    private final Interface iface;
    private final FieldValueSpec[] specs;
    private final DataValidator validator = new DefaultDataValidator();
    private final ToStringMaster stringer = new IndentingToStringMaster();
    private final ArraysEqualsMaster arrays = new DefaultArraysEqualsMaster();

    public DataLayer(Interface iface, FieldValueSpec[] specs) {
        validator.check(specs, iface);
        this.iface = iface;
        this.specs = specs;
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
        for (FieldValueSpec field : specs) {
            if (same(name, field)) return field.getValue();
        }
        throw new UnsupportedOperationException("" + method);
    }

    private boolean same(String match, FieldValueSpec field) {
        String name = field.getName();
        return match.equals(name);
    }

    // FIX 2130 Tidy this rot.
    public Boolean calculateEquals(Object o) {
        if (o == null) return false;
        if (!proxy(o)) return false;
        InvocationHandler handler = Proxy.getInvocationHandler(o);
        return calculateEquals(handler);
    }

    // FIX 2130 Tidy this rot.
    private Boolean calculateEquals(InvocationHandler handler) {
        if (!(handler instanceof Layered)) return false;
        Layered layered = (Layered) handler;
        DataLayer layer = (DataLayer) layered.layer();
        return equals(this, layer);
    }

    // FIX 2130 Tidy this.  No train wrecks.
    private Boolean equals(DataLayer d1, DataLayer d2) {
        FieldValueSpec[] s1 = d1.specs;
        FieldValueSpec[] s2 = d2.specs;
        return arrays.equals(s1, s2);
    }

    // FIX 2130 This can be tidied significantly by adding a marker in ProxyFactory.
    private boolean proxy(Object o) {
        return Proxy.isProxyClass(o.getClass());
    }

    private String calculateToString() {
        Class type = iface.getType();
        String string = stringer.string(specs);
        ClassMaster classer = new DefaultClassMaster();
        // FIX 2130 Use or lose.  Prob lose.
//        return classer.getShortName(type) + " proxied by " + string;
        return classer.getShortName(iface) + string;
    }

    private Integer calculateHashCode() {
        int hashCode = iface.hashCode();
        for (int i = 0; i < specs.length; i++) {
            hashCode = hashCode + 31 * specs[i].hashCode();
        }
        return new Integer(hashCode);
    }
}
