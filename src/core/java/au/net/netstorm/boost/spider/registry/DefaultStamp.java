package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.bullet.primmm.Primordial;

public final class DefaultStamp extends Primordial implements Stamp {
    private final String value;

    DefaultStamp(String value) {
        this.value = value;
        validate();
    }

    private void validate() {
        if (value == null) throw new IllegalArgumentException();
    }
}
