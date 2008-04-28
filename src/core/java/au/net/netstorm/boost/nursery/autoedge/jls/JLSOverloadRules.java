package au.net.netstorm.boost.nursery.autoedge.jls;


public interface JLSOverloadRules {
    boolean compatible(Class<?>[] lhs, Class<?>[] rhs);
    boolean moreSpecific(Class<?>[] lhs, Class<?>[] rhs);
}
