package au.net.netstorm.boost.gunge.aggregator;

import java.io.File;

public interface ClassNameLocator {
    JavaClass[] locate(File root, RegexPattern pattern);
}
