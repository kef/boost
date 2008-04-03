package au.net.netstorm.boost.gunge.aggregator;

import java.io.File;

public interface FileSystemLocator {
    File locate(Class cls);
}
