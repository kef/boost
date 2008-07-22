package au.net.netstorm.boost.spider.resolve;

public interface Resolver {
    <T> T resolve(Class<T> type);
}
