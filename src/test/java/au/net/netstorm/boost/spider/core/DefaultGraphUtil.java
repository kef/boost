package au.net.netstorm.boost.spider.core;

import au.net.netstorm.boost.gunge.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.gunge.reflect.util.FieldTestUtil;
import au.net.netstorm.boost.nursery.spider.onion.core.DefaultPeeler;
import au.net.netstorm.boost.nursery.spider.onion.core.Peeler;

public final class DefaultGraphUtil implements GraphUtil {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final Peeler peeler = new DefaultPeeler();

    public Object get(Object ref, String chain) {
        String[] links = toLinks(chain);
        Object o = get(ref, links, 0);
        return peeler.peel(o);
    }

    public void set(Object ref, String chain, Object instance) {
        String[] links = toLinks(chain);
        set(ref, links, instance, 0);
    }

    private Object get(Object ref, String[] links, int i) {
        if (i == links.length) return ref;
        Object field = field(ref, links[i]);
        return get(field, links, i + 1);
    }

    private void set(Object ref, String[] links, Object instance, int i) {
        if (i == links.length) return;
        Object value = field(ref, links[i]);
        if (i != links.length - 1) set(value, links, instance, i + 1);
        else fielder.setInstance(ref, links[i], instance);
    }

    private Object field(Object ref, String property) {
        Object peeled = peeler.peel(ref);
        return fielder.getInstance(peeled, property);
    }

    private String[] toLinks(String chain) {
        return chain.split("\\.");
    }
}
