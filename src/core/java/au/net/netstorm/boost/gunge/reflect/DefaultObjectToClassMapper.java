package au.net.netstorm.boost.gunge.reflect;

// FIX 2328 Changed name from '2' to 'To'.  Consider using 2 everywhere.
public class DefaultObjectToClassMapper implements ObjectToClassMapper {
    public Class<?> map(Object src) {
        return src.getClass();
    }
}
