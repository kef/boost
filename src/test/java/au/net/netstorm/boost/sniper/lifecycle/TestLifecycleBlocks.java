package au.net.netstorm.boost.sniper.lifecycle;

public interface TestLifecycleBlocks {
    Class[] getPre();

    Class[] getPost();

    Class[] getCleanup();
}
