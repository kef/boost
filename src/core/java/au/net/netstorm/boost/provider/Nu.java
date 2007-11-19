package au.net.netstorm.boost.provider;

public interface Nu {
    <T> T nu(Class<T> impl, Object... params);
}
