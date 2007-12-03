package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.spider.core.Constructable;
import au.net.netstorm.boost.spider.instantiate.Nu;

public class DefaultTestLifecycleBlockRunner implements TestLifecycleBlockRunner, Constructable {
    private final Class<? extends TestLifecycleBlocks> lifecycleClass;
    private TestLifecycleBlocks blocks;
    Nu nu;

    public DefaultTestLifecycleBlockRunner(Class<? extends TestLifecycleBlocks> lifecycleClass) {
        this.lifecycleClass = lifecycleClass;
    }

    public void constructor() {
        blocks = nu.nu(lifecycleClass);
    }

    public void pre() {
        Class[] pre = blocks.getPre();
        execute(pre);
    }

    public void post() {
        Class[] post = blocks.getPost();
        execute(post);
    }

    public void cleanup() {
        Class[] cleanup = blocks.getCleanup();
        execute(cleanup);
    }

    private void execute(Class[] blocks) {
        for (Class cls : blocks) {
            TestLifecycleBlock block = (TestLifecycleBlock) nu.nu(cls);
            block.execute();
        }
    }
}
