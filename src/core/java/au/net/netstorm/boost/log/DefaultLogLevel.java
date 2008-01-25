package au.net.netstorm.boost.log;

import au.net.netstorm.boost.primordial.Primordial;

final class DefaultLogLevel extends Primordial implements LogLevel {
    private final String name;

    public DefaultLogLevel(String name) {
        if (name == null) throw new IllegalArgumentException();
        this.name = name;
    }
}
