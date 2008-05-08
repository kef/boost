package au.net.netstorm.boost.edge.guts;

import java.lang.reflect.Method;

public interface ReturnEdger {
    Object edge(Method edgeMethod, Object realReturn);
}
