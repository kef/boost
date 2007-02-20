package au.net.netstorm.boost.test.aggregator;

public interface ClassNameLocator {
    JavaClass[] locate(Class starter, RegexPattern pattern);
}
