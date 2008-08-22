package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.nursery.proxy.DefaultMethod;
import au.net.netstorm.boost.scalpel.testdata.edge.Arrayo;
import au.net.netstorm.boost.scalpel.testdata.edge.BadArrayo;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;
import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

public final class DefaultArrayoFixture implements ArrayoFixture {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Class real = au.net.netstorm.boost.scalpel.testdata.edge.Arrayo.class;

    public Method edgedMulti() {
        String name = "multi";
        return method(Arrayo.class, name);
    }

    public Method edgedSingle() {
        return method(Arrayo.class, "single");
    }

    public Method edgedReal() {
        return method(Arrayo.class, "real");
    }

    public Method realMulti() {
        return method(real, "multi");
    }

    public Method badEdgedMulti() {
        return method(BadArrayo.class, "multi");
    }

    private Method method(Class cls, String name) {
        java.lang.reflect.Method method = classer.getDeclaredMethod(cls, name);
        return new DefaultMethod(method);
    }
}
