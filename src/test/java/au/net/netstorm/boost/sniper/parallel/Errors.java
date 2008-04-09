package au.net.netstorm.boost.sniper.parallel;

public interface Errors extends Iterable<Throwable> {
    void thrown(Throwable t);

    Boolean isEmpty();

    void assertOk();
}
