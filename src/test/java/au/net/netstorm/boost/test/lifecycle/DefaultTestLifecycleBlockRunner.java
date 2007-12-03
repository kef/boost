package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.spider.instantiate.Nu;

public class DefaultTestLifecycleBlockRunner implements TestLifecycleBlockRunner {
    private final TestLifecycleBlocks lifecycle;
    Nu nu;

    public DefaultTestLifecycleBlockRunner(TestLifecycleBlocks lifecycle) {
        this.lifecycle = lifecycle;
    }

    public void pre() {
        Class[] pre = lifecycle.getPre();
        execute(pre);
    }

    public void post() {
        Class[] post = lifecycle.getPost();
        execute(post);
    }

    public void cleanup() {
        Class[] cleanup = lifecycle.getCleanup();
        execute(cleanup);
    }

    private void execute(Class[] blocks) {
        for (Class cls : blocks) {
            TestLifecycleBlock block = (TestLifecycleBlock) nu.nu(cls);
            block.execute();
        }
    }
}
