package au.net.netstorm.boost.test.aggregator;

import au.net.netstorm.boost.primordial.Primordial;

// FIXME: SC043 Instancise.

final class RegexPattern extends Primordial {
    private final String pattern;

    public RegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
