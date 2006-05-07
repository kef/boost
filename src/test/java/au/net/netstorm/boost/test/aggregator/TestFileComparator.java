package au.net.netstorm.boost.test.aggregator;

import java.io.File;
import java.util.Comparator;

final class TestFileComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        String name1 = getName(o1);
        String name2 = getName(o2);
        return name1.compareTo(name2);
    }

    private String getName(Object ref) {
        return ((File) ref).getName();
    }
}
