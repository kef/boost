package au.net.netstorm.boost.edge.java.lang;

import au.net.netstorm.boost.spider.core.GoodCitizen;

public final class DefaultEdgeSystem implements EdgeSystem, GoodCitizen {

    public String getProperty(String key) {
        return System.getProperty(key);
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }
}
