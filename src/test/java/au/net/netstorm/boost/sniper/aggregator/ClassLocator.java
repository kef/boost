package au.net.netstorm.boost.sniper.aggregator;

import java.io.File;

public interface ClassLocator {
    Class[] locate(File root, RegexPattern pattern);
}
