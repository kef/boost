package au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.sites.InjectionSite;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.Resolvable;
import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.resolve.DefaultResolvable;

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
