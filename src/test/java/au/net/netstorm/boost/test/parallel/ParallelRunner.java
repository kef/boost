package au.net.netstorm.boost.test.parallel;

// FIX 2000 Use or Lose.
public interface ParallelRunner {
    void run(ParallelTestCase test, Integer threads) throws Throwable;
}
