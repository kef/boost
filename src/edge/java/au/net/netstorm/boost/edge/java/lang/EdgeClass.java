package au.net.netstorm.boost.edge.java.lang;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface EdgeClass {
    Object newInstance();

    Method getMethod(String methodName, Class[] parameterTypes);

    Field getDeclaredField(String fieldName);

    Class getNonEdge();
}
// FIXME: SC600 Evaluate SUGGEST.  The more I see the more I think we do this.
// SUGGEST: Return EdgeMethod, EdgeField...  Requires across the board change to utilities.
