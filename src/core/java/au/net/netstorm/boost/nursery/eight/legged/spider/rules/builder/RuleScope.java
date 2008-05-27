package au.net.netstorm.boost.nursery.eight.legged.spider.rules.builder;

public interface RuleScope {
    void in(Class<?> host);
    void in(Class<?> host, String name);
    void in(String name);
}
