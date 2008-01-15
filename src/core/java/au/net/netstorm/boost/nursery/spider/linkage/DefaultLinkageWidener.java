package au.net.netstorm.boost.nursery.spider.linkage;

import java.util.ArrayList;
import java.util.List;

public final class DefaultLinkageWidener implements LinkageWidener {
    LinkageWildcard wildcard = new DefaultLinkageWildcard();

    public Linkage[] widen(Linkage linkage) {
        List result = new ArrayList();
        widen(linkage, result);
        return (Linkage[]) result.toArray(new Linkage[]{});
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
