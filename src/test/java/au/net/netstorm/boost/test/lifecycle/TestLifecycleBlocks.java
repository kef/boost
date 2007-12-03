package au.net.netstorm.boost.test.lifecycle;

public interface TestLifecycleBlocks {
    Class[] getPre();

    Class[] getPost();

    Class[] getCleanup();
}
