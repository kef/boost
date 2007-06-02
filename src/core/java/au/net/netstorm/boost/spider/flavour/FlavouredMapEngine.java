package au.net.netstorm.boost.spider.flavour;

// FIX 1977 Scope of FlavouredMapEngine stuff should be package private.
public interface FlavouredMapEngine {
    void put(FlavouredInterface flavour, Object value);

    Object get(FlavouredInterface flavour);
}
