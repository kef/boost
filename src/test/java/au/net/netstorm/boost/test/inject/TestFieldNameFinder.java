package au.net.netstorm.boost.test.inject;

import java.util.List;
import au.net.netstorm.boost.test.automock.UsesMocks;

public interface TestFieldNameFinder {
    List find(UsesMocks testCase);
}
