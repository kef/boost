package au.net.netstorm.boost.test.aggregator;

import au.net.netstorm.boost.primordial.Primordial;

final class TestRegexPattern extends Primordial implements RegexPattern {
    private final String pattern;

    public TestRegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
