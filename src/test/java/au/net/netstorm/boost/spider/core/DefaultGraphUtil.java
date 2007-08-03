package au.net.netstorm.boost.spider.core;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import au.net.netstorm.boost.edge.java.lang.DefaultEdgeClass;
import au.net.netstorm.boost.edge.java.lang.EdgeClass;
import au.net.netstorm.boost.edge.java.lang.reflect.DefaultEdgeMethod;
import au.net.netstorm.boost.edge.java.lang.reflect.EdgeMethod;
import au.net.netstorm.boost.test.atom.Captialiser;
import au.net.netstorm.boost.test.atom.DefaultCaptialiser;

// FIX BREADCRUMB 1977 EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE Stitch into existing tests for graphs.
public final class DefaultGraphUtil implements GraphUtil {
    private final Captialiser captialiser = new DefaultCaptialiser();
    private final EdgeClass classer = new DefaultEdgeClass();
    private final EdgeMethod methoder = new DefaultEdgeMethod();
    private Class[] noargs = {};

    public Object get(Object ref, String chain) {
        String[] links = toLinks(chain);
        return get(ref, links, 0);
    }

    private Object get(Object ref, String[] links, int i) {
        if (i == links.length) return ref;
        Object field = method(ref, links[i]);
        return get(field, links, i + 1);
    }

    private Object method(Object ref, String property) {
        Class type = ref.getClass();
        String upper = captialiser.captialise(property);
        String name = "get" + upper;
        Method method = classer.getMethod(type, name, noargs);
        return methoder.invoke(method, ref, noargs);
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
