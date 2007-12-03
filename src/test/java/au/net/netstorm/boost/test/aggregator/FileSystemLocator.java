package au.net.netstorm.boost.test.aggregator;

import java.io.File;

public interface FileSystemLocator {
    File locate(Class cls);
}
