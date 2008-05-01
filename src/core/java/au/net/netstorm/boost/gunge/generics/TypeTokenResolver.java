package au.net.netstorm.boost.gunge.generics;

public interface TypeTokenResolver {
    TypeTokenInstance resolve(Class<?> tokenInterface, Class<?> token);
}
