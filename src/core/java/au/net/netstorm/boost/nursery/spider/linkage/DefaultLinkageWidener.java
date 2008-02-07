package au.net.netstorm.boost.nursery.spider.linkage;

import au.net.netstorm.boost.spider.linkage.Linkage;
import au.net.netstorm.boost.util.array.ArrayMaster;
import au.net.netstorm.boost.util.array.DefaultArrayMaster;

import java.util.ArrayList;
import java.util.List;

// FIX ()  2237 Move this out of the nursery.
public final class DefaultLinkageWidener implements LinkageWidener {
    private final LinkageWildcard wildcard = new DefaultLinkageWildcard();
    private final ArrayMaster arrays = new DefaultArrayMaster();

    public Linkage[] widen(Linkage linkage) {
        List<Linkage> result = new ArrayList<Linkage>();
        widen(linkage, result);
        return arrays.toArray(result, Linkage.class);
    }

    private void widen(Linkage linkage, List result) {
        widest(linkage, result);
        widenName(linkage, result);
        widenHost(linkage, result);
        widenBoth(linkage, result);
    }

    private void widest(Linkage linkage, List result) {
        result.add(linkage);
    }

    private void widenName(Linkage linkage, List result) {
        if (linkage.named()) {
            Linkage widened = wildcard.name(linkage);
            result.add(widened);
        }
    }

    private void widenHost(Linkage linkage, List result) {
        if (linkage.hosted()) {
            Linkage widened = wildcard.host(linkage);
            result.add(widened);
        }
    }

    private void widenBoth(Linkage linkage, List result) {
        if (linkage.hosted() && linkage.named()) {
            Linkage widened = wildcard.both(linkage);
            result.add(widened);
        }
    }
}
