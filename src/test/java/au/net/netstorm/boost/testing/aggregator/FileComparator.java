package au.net.netstorm.boost.testing.aggregator;

import java.io.File;
import java.util.Comparator;

class FileComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        return ((File) o1).getName().compareTo(((File) o2).getName());
    }
}
