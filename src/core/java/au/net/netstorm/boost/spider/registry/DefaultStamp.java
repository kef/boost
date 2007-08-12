package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultStamp extends Primordial implements Stamp {
    private final String value;

    DefaultStamp(String value) {
        this.value = value;
        if (value == null)
            throw new IllegalArgumentException();
    }
}
