package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;

public final class DefaultResolvables implements Resolvables {
    private final List<Resolvable> resolvables = new ArrayList<Resolvable>();

    public void add(InjectionSite host, InjectionSite[] sites) {
        Resolvable resolvable = new DefaultResolvable(host, sites);
        resolvables.add(resolvable);
    }

    public Iterator<Resolvable> iterator() {
        return resolvables.iterator();
    }
}
