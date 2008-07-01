package au.net.netstorm.boost.spider.resolve;

public interface Resolver {
    // FIX 2394 it would be nice to have a super resolver, that worked on binding details, i.e. type, host, name
    <T> T resolve(Class<T> type);
}
