package demo.edge.java.net;

import au.net.netstorm.boost.edge.core.Edge;

public interface URL extends Edge<java.net.URL> {
    String toExternalForm();
}
