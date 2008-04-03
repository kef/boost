package au.net.netstorm.boost.gunge.parallel;

public interface ThreadRunner {
    Errors run(Runnable runnable, int count);
}
