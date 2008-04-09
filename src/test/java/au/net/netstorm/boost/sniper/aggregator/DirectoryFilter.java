package au.net.netstorm.boost.sniper.aggregator;

import java.io.File;
import java.io.FileFilter;

final class DirectoryFilter implements FileFilter {
    public boolean accept(File pathname) {
        return pathname.isDirectory();
    }
}
