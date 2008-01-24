package au.net.netstorm.boost.spider.onion.layer.closure;

final class DefaultPie implements Pie {
    private boolean cooked;

    public void cook() {
        cooked = true;
    }

    public boolean hotAndTasty() {
        return cooked;
    }
}
