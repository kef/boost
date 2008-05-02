package au.net.netstorm.boost.gunge.reflect;

import java.lang.reflect.Constructor;


public class DefaultMostSpecificSignatureFinder implements MostSpecificSignatureFinder {
    private Constructor<?> result;
    MethodSignatureRules jls;

    public boolean next(Constructor<?> c) {
        if (moreSpecific(c, result)) result = c;
        return true;
    }

    public Constructor<?> result() {
        return result;
    }

    private boolean moreSpecific(Constructor<?> lhs, Constructor<?> rhs) {
        if (rhs == null) return true;
        Class<?>[] lTypes = lhs.getParameterTypes();
        Class<?>[] rTypes = rhs.getParameterTypes();
        return jls.moreSpecific(rTypes, lTypes);
    }
}
