package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.postprocess;

import java.util.IdentityHashMap;
import java.util.Map;

import au.net.netstorm.boost.bullet.primordial.Primordial;
import au.net.netstorm.boost.spider.core.Constructable;

// FIX 2394 Naive constructor implementation. think about it some more.
public final class DefaultConstructables extends Primordial implements Constructables {
    // FIX 2394 should be a set. also should be using weak refs.
    private final Map done = new IdentityHashMap();

    public synchronized void construct(Object ref) {
        if (done.containsKey(ref)) return;
        if (!(ref instanceof Constructable)) return;
        Constructable constructable = (Constructable) ref;
        constructable.constructor();
        done.put(ref, null);
    }
}
