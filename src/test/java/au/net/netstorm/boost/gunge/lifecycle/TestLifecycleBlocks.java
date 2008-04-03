package au.net.netstorm.boost.gunge.lifecycle;

public interface TestLifecycleBlocks {
    Class[] getPre();

    Class[] getPost();

    Class[] getCleanup();
}
