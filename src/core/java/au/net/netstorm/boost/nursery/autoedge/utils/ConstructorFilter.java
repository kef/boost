package au.net.netstorm.boost.nursery.autoedge.utils;


import java.lang.reflect.Constructor;
import java.util.List;

public interface ConstructorFilter {
    List<Constructor<?>> filter(Class<?> type, Object... params);
}
