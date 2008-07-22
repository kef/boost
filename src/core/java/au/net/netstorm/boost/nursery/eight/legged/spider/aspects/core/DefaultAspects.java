package au.net.netstorm.boost.nursery.eight.legged.spider.aspects.core;

import java.util.List;

import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.ArrayListCreator;

// FIX 2394 Use or lose. Wire into AspectResolver.
public final class DefaultAspects implements Aspects {
    // FIX 2394 create some nice interfaces for these somehow.
    private final IntegrityMap<Class, List<Class<? extends Aspect>>> aspects = new DefaultIntegrityMap();
    private final Creator<Class, List<Class<? extends Aspect>>> creator = new ArrayListCreator();

    public void add(Class iface, Class<? extends Aspect> aspect) {
        List<Class<? extends Aspect>> classes = aspects.get(iface, creator);
        classes.add(aspect);
    }

    public Class<? extends Aspect>[] get(Class iface) {
        List<Class<? extends Aspect>> classes = aspects.get(iface, creator);
        return classes.toArray(new Class[classes.size()]);
    }
}
