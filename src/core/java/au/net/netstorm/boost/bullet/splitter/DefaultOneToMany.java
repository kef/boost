package au.net.netstorm.boost.bullet.splitter;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.gunge.array.ArrayMaster;
import au.net.netstorm.boost.gunge.array.DefaultArrayMaster;
import au.net.netstorm.boost.gunge.proxy.DefaultLayerFactory;
import au.net.netstorm.boost.gunge.proxy.LayerFactory;
import au.net.netstorm.boost.gunge.type.Interface;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class DefaultOneToMany implements OneToMany, Layer {
    private final LayerFactory factory = new DefaultLayerFactory();
    private final ArrayMaster arrays = new DefaultArrayMaster();
    private final List many = new ArrayList();
    private final Interface type;

    public DefaultOneToMany(Interface type) {
        noNulls(type);
        this.type = type;
    }

    public synchronized void add(Object oneOfMany) {
        noNulls(oneOfMany);
        many.add(oneOfMany);
    }

    public synchronized Object getOne() {
        return factory.newProxy(type, this);
    }

    public synchronized Object invoke(Method method, Object[] args) {
        Object[] listeners = arrays.toArray(many);
        invoke(listeners, method, args);
        return null;
    }

    private void invoke(Object[] listeners, Method method, Object[] parameters) {
        for (Object listener : listeners) {
            method.invoke(listener, parameters);
        }
    }

    private void noNulls(Object ref) {
        if (ref == null) {
            throw new IllegalArgumentException();
        }
    }
}
