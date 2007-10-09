package au.net.netstorm.boost.nursery.log;

import au.net.netstorm.boost.primordial.Primordial;

class DefaultLogLevel extends Primordial implements LogLevel {
    private final String name;

    public DefaultLogLevel(String name) {
        this.name = name;
    }
}
