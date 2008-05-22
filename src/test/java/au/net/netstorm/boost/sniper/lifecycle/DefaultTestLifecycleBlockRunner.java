package au.net.netstorm.boost.sniper.lifecycle;

import au.net.netstorm.boost.spider.instantiate.NuImpl;

public class DefaultTestLifecycleBlockRunner implements TestLifecycleBlockRunner {
    private final TestLifecycleBlocks lifecycle;
    NuImpl nuImpl;

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
            TestLifecycleBlock block = (TestLifecycleBlock) nuImpl.nu(cls);
            block.execute();
        }
    }
}
