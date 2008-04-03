package au.net.netstorm.boost.gunge.aggregator;

import java.io.File;
import java.net.URL;

public class DefaultFileSystemLocator implements FileSystemLocator {
    public File locate(Class cls) {
        URL resource = cls.getResource("/");
        String root = resource.getFile();
        return new File(root);
    }
}
