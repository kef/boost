package au.net.netstorm.boost.testing.aggregator;

import java.io.File;
import java.io.FileFilter;

class DirectoryFilter implements FileFilter {
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }
}
