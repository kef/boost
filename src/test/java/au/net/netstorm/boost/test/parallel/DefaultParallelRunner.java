package au.net.netstorm.boost.test.parallel;

// FIX 2000 Use or Lose.
public class DefaultParallelRunner implements ParallelRunner {
    public void run(ParallelTestCase test, Integer threads) throws Throwable {
        // FIX 2000 Make this bad boy multi-threaded.
        test.runTest();
    }
}
