package au.net.netstorm.boost.gunge.reflect;


import java.lang.reflect.Constructor;
import java.util.List;

public interface ConstructorFilter {
    List<Constructor<?>> filter(Class<?> type, Object... params);
}
