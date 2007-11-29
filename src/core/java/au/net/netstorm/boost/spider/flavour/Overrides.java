package au.net.netstorm.boost.spider.flavour;

public interface Overrides {
    String ALLOW_OVERRIDES = "spider.allow.overrides";

    boolean allowed();
}
