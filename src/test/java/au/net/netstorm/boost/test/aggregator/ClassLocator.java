package au.net.netstorm.boost.test.aggregator;

import java.io.File;

interface ClassLocator {
    JavaClass[] locate(File root, RegexPattern pattern);
}
