package au.net.netstorm.boost.gunge.provider;

public interface SpecificProvider extends Provider {
    boolean canProvide(Class<?> type);
}
