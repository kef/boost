package au.net.netstorm.boost.nursery.autoedge;

import java.lang.reflect.Method;

public interface ReturnEdger {
    Object edge(Method edgeMethod, Object realReturn);
}
