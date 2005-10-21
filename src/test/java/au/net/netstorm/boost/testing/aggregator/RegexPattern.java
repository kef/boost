package au.net.netstorm.boost.testing.aggregator;

class RegexPattern {
    private final String pattern;

    public RegexPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }

    public String toString() {
        return "RegexPattern[" + pattern + "]";
    }
}
