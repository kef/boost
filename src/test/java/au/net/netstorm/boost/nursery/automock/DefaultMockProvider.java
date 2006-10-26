package au.net.netstorm.boost.nursery.automock;

import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

public final class DefaultMockProvider implements MockProvider {
    private MockObjectTestCase jMock = new MockObjectTestCase(){};

    public Mock mock(Class mockType) {
        return jMock.mock(mockType);
    }

    public Mock mock(Class mockType, String role) {
        return jMock.mock(mockType, role);
    }
}
