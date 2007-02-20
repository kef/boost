package au.net.netstorm.boost.test.aggregator;

public interface ClassLocator {
    Class[] locate(Class starter, RegexPattern pattern);
}
