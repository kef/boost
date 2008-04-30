package au.net.netstorm.boost.nursery.autoedge.utils;

public class DefaultJLSOverloadRules implements JLSOverloadRules {
    public boolean compatible(Class<?>[] lhs, Class<?>[] rhs) {
        if (lhs.length != rhs.length) return false;
        for (int i = 0; i < lhs.length; ++i) {
            if (!assignable(lhs[i], rhs[i])) return false;
        }
        return true;
    }

    // FIX 2328 handle primitives ??
    private boolean assignable(Class<?> lhs, Class<?> rhs) {
        return lhs.isAssignableFrom(rhs);
    }

    public boolean moreSpecific(Class<?>[] lhs, Class<?>[] rhs) {
        return compatible(rhs, lhs) && !compatible(lhs, rhs);
    }
}
