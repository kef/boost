package au.net.netstorm.boost.sniper.lifecycle;

public class BoostTestLifecycleBlocks implements TestLifecycleBlocks {
    // FIX 2328 this is duplicated with additions in each test type
    // FIX 2328 really needs to be addressed now, I pushed in the
    // FIX 2328 InitializeSubject block and it should not have to be
    // FIX 2328 be copied everywhere
    private final Class[] pre = {
            ValidateTest.class,
            DataRegisterer.class,
            InjectLazyFields.class,
            CallOverlaysWeb.class,
            InitializeSubject.class,
            InjectTest.class,
            CallSetupFixtures.class,
            InjectSubject.class
    };
    private final Class[] post = {
            VerifyExpectations.class
    };
    private final Class[] cleanup = {
            DestroyTest.class
    };

    public Class[] getPre() {
        return pre;
    }

    public Class[] getPost() {
        return post;
    }

    public Class[] getCleanup() {
        return cleanup;
    }
}
