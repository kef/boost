package au.net.netstorm.boost.sledge.java.lang;

public final class DefaultEdgeSystem implements EdgeSystem {
    public String getProperty(String key) {
        return System.getProperty(key);
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
