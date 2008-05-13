package au.net.netstorm.boost.scalpel.guts;

import java.lang.reflect.Method;

public interface ReturnEdger {
    Object edge(Method edgeMethod, Object realReturn);
}
