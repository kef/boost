package au.net.netstorm.boost.test.automock;

public abstract class InteractionTestCase extends StrategyTestCase implements UsesMocks {
    // FIX 1715 Make this final.  Use pass through.
    protected MockExpectations expect;
}
