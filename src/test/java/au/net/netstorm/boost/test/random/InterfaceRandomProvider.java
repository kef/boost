package au.net.netstorm.boost.test.random;

import au.net.netstorm.boost.test.automock.DefaultMockProvider;
import au.net.netstorm.boost.test.automock.MockProvider;
import org.jmock.Mock;
import org.jmock.MockObjectTestCase;

public final class InterfaceRandomProvider implements RandomProvider {
    private MockObjectTestCase jMock = new MockObjectTestCase() {
    };
    private MockProvider provider = new DefaultMockProvider(jMock);

    public Object get(Class type) {
        Mock mock = provider.mock(type);
        return mock.proxy();
    }
}
