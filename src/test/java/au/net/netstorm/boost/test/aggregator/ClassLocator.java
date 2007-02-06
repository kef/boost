package au.net.netstorm.boost.test.aggregator;

public interface ClassLocator {
    JavaClass[] locate(Class starter, RegexPattern pattern);
}
