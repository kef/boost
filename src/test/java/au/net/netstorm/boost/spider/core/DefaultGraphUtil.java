package au.net.netstorm.boost.spider.core;

import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;

// FIX BREADCRUMB 1977 EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE Stitch into existing tests for graphs.
public final class DefaultGraphUtil implements GraphUtil {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();

    public Object get(Object ref, String chain) {
        String[] links = toLinks(chain);
        return get(ref, links, 0);
    }

    private Object get(Object ref, String[] links, int i) {
        if (i == links.length) return ref;
        Object field = fielder.getInstance(ref, links[i]);
        return get(field, links, i + 1);
    }

    private String[] toLinks(String chain) {
        List list = new ArrayList();
        getLinks(list, chain);
        return (String[]) list.toArray(new String[]{});
    }

    private void getLinks(List list, String chain) {
        int i = chain.lastIndexOf(".");
        if (i == -1) {
            list.add(chain);
            return;
        }
        String shorter = chain.substring(0, i);
        getLinks(list, shorter);
    }
}
