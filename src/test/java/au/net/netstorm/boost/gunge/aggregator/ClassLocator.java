package au.net.netstorm.boost.gunge.aggregator;

import java.io.File;

public interface ClassLocator {
    Class[] locate(File root, RegexPattern pattern);
}
