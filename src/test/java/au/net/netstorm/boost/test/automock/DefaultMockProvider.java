package au.net.netstorm.boost.test.automock;

import java.util.Random;
import org.jmock.Mock;

public final class DefaultMockProvider implements MockProvider {
    private Random random = new Random();
    private MockObjectTestCase jMock;

    public DefaultMockProvider(MockObjectTestCase jMock) {
        this.jMock = jMock;
    }

    public Mock mock(Class mockType) {
        return jMock.mock(mockType);
    }

    public Mock mock(Class mockType, String role) {
        return jMock.mock(mockType, role + "(" + random() + ")");
    }

    private int random() {
        return random.nextInt();
    }
}
