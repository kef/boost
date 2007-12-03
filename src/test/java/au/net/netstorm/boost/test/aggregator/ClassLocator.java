package au.net.netstorm.boost.test.aggregator;

import java.io.File;

public interface ClassLocator {
    Class[] locate(File root, RegexPattern pattern);
}
