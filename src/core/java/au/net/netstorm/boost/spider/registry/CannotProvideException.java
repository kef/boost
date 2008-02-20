package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.PrimordialException;
import au.net.netstorm.boost.spider.linkage.Linkage;

public final class CannotProvideException extends PrimordialException {
    public CannotProvideException(Linkage linkage) {
        super("Cannot provide an implementation for linkage " + linkage);
    }
}
