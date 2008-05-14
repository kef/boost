package au.net.netstorm.boost.sniper.lifecycle;

public final class InitializeSubject implements TestLifecycleBlock {
    public void execute() {
        // FIX 2328 if test is marked with InjectSubject create an instance of subject with no dependencies
    }
}
