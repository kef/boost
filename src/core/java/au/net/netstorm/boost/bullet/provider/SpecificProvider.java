package au.net.netstorm.boost.bullet.provider;

public interface SpecificProvider extends Provider {
    boolean canProvide(Class<?> type);
}
