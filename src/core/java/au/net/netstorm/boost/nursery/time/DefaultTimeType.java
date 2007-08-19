package au.net.netstorm.boost.nursery.time;

import au.net.netstorm.boost.primordial.Primordial;

public final class DefaultTimeType extends Primordial implements TimeType {
    private final String name;

    DefaultTimeType(String name) {
        this.name = name;
    }
}
