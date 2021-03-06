package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import java.util.Set;

import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.SetCreator;
import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.spider.onion.core.Layer;

public final class DefaultAspects implements Aspects {
    // FIX 2394 create some nice interfaces for these somehow.
    private final IntegrityMap<Class, Set<Class<? extends Layer>>> aspects = new DefaultIntegrityMap();
    private final Creator<Class, Set<Class<? extends Layer>>> creator = new SetCreator();

    public void add(Class iface, Class<? extends Layer> aspect) {
        Set<Class<? extends Layer>> classes = aspects.get(iface, creator);
        classes.add(aspect);
    }

    public Class<? extends Layer>[] get(Class iface) {
        Set<Class<? extends Layer>> classes = aspects.get(iface, creator);
        return classes.toArray(new Class[classes.size()]);
    }
}
