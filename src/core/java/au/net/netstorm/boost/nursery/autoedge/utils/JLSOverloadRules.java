package au.net.netstorm.boost.nursery.autoedge.utils;


public interface JLSOverloadRules {
    boolean compatible(Class<?>[] lhs, Class<?>[] rhs);
    boolean moreSpecific(Class<?>[] lhs, Class<?>[] rhs);
}
