package au.net.netstorm.boost.demo.spider.resolve;

public final class StolenMemorabilia implements Memorabilia {
    private final Class owner;

    public StolenMemorabilia(Class owner) {
        this.owner = owner;
    }

    public Class getOwner() {
        return owner;
    }
}
