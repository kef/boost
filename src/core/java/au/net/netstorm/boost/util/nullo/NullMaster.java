package au.net.netstorm.boost.util.nullo;

public interface NullMaster {
    void check(Object parameter, String parameterName);

    void check(Object[] parameters);
}
