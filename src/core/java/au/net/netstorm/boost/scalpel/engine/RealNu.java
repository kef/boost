package au.net.netstorm.boost.scalpel.engine;

public interface RealNu {
    <R> R nu(Class<R> real, Object... edgedArgs);
}
