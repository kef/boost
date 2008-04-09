package au.net.netstorm.boost.spider.register;

import au.net.netstorm.boost.bullet.primordial.PrimordialException;
import au.net.netstorm.boost.spider.linkage.Linkage;

public final class CannotProvideException extends PrimordialException {
    public CannotProvideException(Linkage linkage) {
        super("Cannot provide an implementation for linkage " + linkage);
    }
}
