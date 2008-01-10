package au.net.netstorm.boost.nursery.spider.registry;

import au.net.netstorm.boost.primordial.PrimordialException;

public final class CannotProvideException extends PrimordialException {
    public CannotProvideException(Linkage linkage) {
        super("Cannot provide an implementation for linkage " + linkage);
    }
}
