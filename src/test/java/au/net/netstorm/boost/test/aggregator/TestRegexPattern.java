package au.net.netstorm.boost.test.aggregator;

import au.net.netstorm.boost.primordial.Primordial;

// FIXME: SC043 Instancise.

final class TestRegexPattern extends Primordial implements RegexPattern {
    private final String pattern;

    public TestRegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
