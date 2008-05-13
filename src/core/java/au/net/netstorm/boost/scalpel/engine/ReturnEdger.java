package au.net.netstorm.boost.scalpel.engine;

import java.lang.reflect.Method;

public interface ReturnEdger {
    Object edge(Method edgeMethod, Object realReturn);
}
