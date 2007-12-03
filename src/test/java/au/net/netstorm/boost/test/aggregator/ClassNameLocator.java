package au.net.netstorm.boost.test.aggregator;

import java.io.File;

public interface ClassNameLocator {
    JavaClass[] locate(File root, RegexPattern pattern);
}
