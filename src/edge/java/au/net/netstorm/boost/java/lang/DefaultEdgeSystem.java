package au.net.netstorm.boost.java.lang;

public final class DefaultEdgeSystem implements EdgeSystem {
    public String getProperty(String key) {
        return System.getProperty(key);
    }
}
