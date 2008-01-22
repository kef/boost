package au.net.netstorm.boost.spider.resolve;

import au.net.netstorm.boost.edge.java.lang.reflect.Method;
import au.net.netstorm.boost.spider.core.Constructable;
import au.net.netstorm.boost.spider.onion.core.Layer;

// FIX ()  94156 Rename.
public final class FooLayer implements Layer, Constructable {
    private final Object ref;
    Love love;
    Hate hate;

    public FooLayer(Object ref) {
        this.ref = ref;
    }

    public void constructor() {
    }

    public Object invoke(Method method, Object[] args) {
        return method.invoke(ref, args);
    }
}
