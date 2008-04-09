package au.net.netstorm.boost.sniper.aggregator;

import java.io.File;

public interface FileSystemLocator {
    File locate(Class cls);
}
