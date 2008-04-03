package au.net.netstorm.boost.gunge.aggregator;

import au.net.netstorm.boost.primordial.Primordial;

public final class TestRegexPattern extends Primordial implements RegexPattern {
    private final String pattern;

    public TestRegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
