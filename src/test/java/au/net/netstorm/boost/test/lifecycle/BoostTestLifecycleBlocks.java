package au.net.netstorm.boost.test.lifecycle;

public class BoostTestLifecycleBlocks implements TestLifecycleBlocks {
    private final Class[] pre = {
            ValidateTest.class,
            DataRegisterer.class,
            InjectLazyFields.class,
            CallOverlaysWeb.class,
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
