package au.net.netstorm.boost.gunge.field;

import java.lang.reflect.Field;

public interface FieldSuffix {
    boolean matches(Field field);

    String addSuffix(Field field);
}
