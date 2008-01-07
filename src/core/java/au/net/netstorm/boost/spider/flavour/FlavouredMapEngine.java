package au.net.netstorm.boost.spider.flavour;

public interface FlavouredMapEngine {
    void put(FlavouredInterface flavour, Object value);

    Object get(FlavouredInterface flavour);

    boolean exists(FlavouredInterface flavour);
}
