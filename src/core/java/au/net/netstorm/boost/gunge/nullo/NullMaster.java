package au.net.netstorm.boost.gunge.nullo;

public interface NullMaster {
    void check(Object parameter, String parameterName);

    void check(Object parameter);

    void check(Object... parameters);
}
