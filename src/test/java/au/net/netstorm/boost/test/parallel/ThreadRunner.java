package au.net.netstorm.boost.test.parallel;

public interface ThreadRunner {
    Errors run(Runnable runnable, int count);
}
