package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Method;

import au.net.netstorm.boost.scalpel.testdata.edge.Arrayo;
import au.net.netstorm.boost.scalpel.testdata.edge.BadArrayo;
import au.net.netstorm.boost.sledge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.sledge.java.lang.EdgeClass;

public final class DefaultArrayoFixture implements ArrayoFixture {
    private final EdgeClass classer = new DefaultEdgeClass();
    private final Class real = au.net.netstorm.boost.scalpel.testdata.edge.Arrayo.class;

    public Method edgedMulti() {
        return classer.getDeclaredMethod(Arrayo.class, "multi");
    }

    public Method edgedSingle() {
        return classer.getDeclaredMethod(Arrayo.class, "single");
    }

    public Method edgedReal() {
        return classer.getDeclaredMethod(Arrayo.class, "real");
    }

    public Method realMulti() {
        return classer.getDeclaredMethod(real, "multi");
    }

    public Method badEdgedMulti() {
        return classer.getDeclaredMethod(BadArrayo.class, "multi");
    }
}
