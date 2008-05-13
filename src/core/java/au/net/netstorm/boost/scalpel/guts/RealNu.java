package au.net.netstorm.boost.scalpel.guts;

public interface RealNu {
    <R> R nu(Class<R> real, Object... edgedArgs);
}
