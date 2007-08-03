package au.net.netstorm.boost.test.lifecycle;

import au.net.netstorm.boost.test.core.RunnableTest;
import au.net.netstorm.boost.test.exception.ExceptionSupportProvider;

public interface LifecycleTest extends RunnableTest, TestLifecycleProvider, ExceptionSupportProvider {
}
