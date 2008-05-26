package au.net.netstorm.boost.nursery.eight.legged.spider.injection.patterns;

public interface InjectionPatternBuilder {
    InjectionPattern pattern(Class<?> host, Class<?> type, String name);
}