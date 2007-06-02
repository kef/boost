package au.net.netstorm.boost.spider.flavour;

final class DefaultFlavouredMapEngine implements FlavouredMapEngine {
    private Object value;

    public void put(FlavouredInterface flavoured, Object value) {
        this.value = value;
    }

    public Object get(FlavouredInterface milkshakeUnflavoured) {
        return value;
    }
}
