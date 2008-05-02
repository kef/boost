package au.net.netstorm.boost.gunge.generics;

public interface TypeResolver {
    TypeInstance resolve(Class<?> token, Class<?>... tokenInterface);
}
