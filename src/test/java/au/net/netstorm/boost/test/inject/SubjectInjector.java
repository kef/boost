package au.net.netstorm.boost.test.inject;

import au.net.netstorm.boost.test.automock.UsesMocks;

public interface SubjectInjector {
    void inject(UsesMocks testCase);
}
