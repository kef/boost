package au.net.netstorm.boost.spider.onion.layer.closure;

final class DefaultOven implements Oven {
    private boolean on;
    private boolean off;

    public void on() {
        on = true;
    }

    public void off() {
        if (on) off = true;
    }

    public boolean used() {
        return on && off;
    }
}
