package au.net.netstorm.boost.gunge.generics;

// FIX 2328 TypeToken is a cumbersome name... think up something shorter and more descriptive (can't be Type)
public interface TypeTokenResolver {
    TypeTokenInstance resolve(Class<?> tokenInterface, Class<?> token);
}
