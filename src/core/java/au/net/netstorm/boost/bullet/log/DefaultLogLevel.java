package au.net.netstorm.boost.bullet.log;

import au.net.netstorm.boost.bullet.primmm.Primordial;

final class DefaultLogLevel extends Primordial implements LogLevel {
    private final String name;

    public DefaultLogLevel(String name) {
        if (name == null) throw new IllegalArgumentException();
        this.name = name;
    }
}
