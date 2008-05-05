package au.net.netstorm.boost.sniper.aggregator;

import au.net.netstorm.boost.bullet.primordial.Primordial;

public final class TestRegexPattern extends Primordial implements RegexPattern {
    private final String pattern;

    public TestRegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
