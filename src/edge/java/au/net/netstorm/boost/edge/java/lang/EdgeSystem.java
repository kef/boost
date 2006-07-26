package au.net.netstorm.boost.edge.java.lang;

public interface EdgeSystem {
    EdgeSystem EDGE_SYSTEM = new DefaultEdgeSystem();

    String getProperty(String key);
}
