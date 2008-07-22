package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import java.util.List;

import au.net.netstorm.boost.gunge.collection.ArrayListCreator;
import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class DefaultAspects implements Aspects {
    // FIX 2394 create some nice interfaces for these somehow.
    private final IntegrityMap<Class, List<Class<? extends Layer>>> aspects = new DefaultIntegrityMap();
    private final Creator<Class, List<Class<? extends Layer>>> creator = new ArrayListCreator();

    public void add(Class iface, Class<? extends Layer> aspect) {
        List<Class<? extends Layer>> classes = aspects.get(iface, creator);
        classes.add(aspect);
    }

    public Class<? extends Layer>[] get(Class iface) {
        List<Class<? extends Layer>> classes = aspects.get(iface, creator);
        return classes.toArray(new Class[classes.size()]);
    }
}
