package au.net.netstorm.boost.sniper.parallel;

public interface ThreadRunner {
    Errors run(Runnable runnable, int count);
}
