package au.net.netstorm.boost.spider.core;

// FIX 2076 Move this out of the spider tree to some place generic - boost.provider?
public interface Provider {
    Object provide(Class type);
}