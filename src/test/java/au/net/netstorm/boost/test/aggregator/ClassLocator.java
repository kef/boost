package au.net.netstorm.boost.test.aggregator;

interface ClassLocator {
    JavaClass[] locate(Class starter, RegexPattern pattern);
}
