package au.net.netstorm.boost.test.automock;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;
import au.net.netstorm.boost.test.reflect.util.DefaultFieldTestUtil;
import au.net.netstorm.boost.test.reflect.util.FieldTestUtil;
import org.jmock.MockObjectTestCase;

// OK ClassDataAbstractionCoupling {
final class MockTestStrategy implements TestStrategy {
    private final FieldTestUtil fielder = new DefaultFieldTestUtil();
    private final MockObjectTestCase mocker = new DefaultMockObjectTestCase();
    private final MockProvider mockProvider = new DefaultMockProvider(mocker);
    private final UsesMocks testCase;

    public MockTestStrategy(UsesMocks testCase) {
        this.testCase = testCase;
    }

    public void init() {
        AutoMocker autoMocker = new DefaultAutoMocker(testCase, mockProvider);
        MockExpectations mockExpectations = buildMockExpectations(autoMocker);
        setExpectField(mockExpectations);
        Field[] fields = getFields(testCase);
        // FIX 32416 set up random fields here
        autoMocker.wireMocks(fields);
        testCase.setupSubjects();
    }

    public void verify() {
        mocker.verify();
    }

    public void destroy() {
    }

    private void setExpectField(MockExpectations mockExpectations) {
        fielder.setInstance(testCase, "expect", mockExpectations);
    }

    private MockExpectations buildMockExpectations(AutoMocker autoMocker) {
        MockExpectationEngine delegate = new DefaultMockExpectationEngine(autoMocker, mocker);
        return new DefaultMockExpectations(delegate);
    }

    private Field[] getFields(Object ref) {
        Field[] fields = getDeclaredFields(ref);
        return siftOutSyntheticFields(fields);
    }

    // FIX 1665 Do we really need this.
    private Field[] siftOutSyntheticFields(Field[] fields) {
        Set result = new HashSet();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            if (!field.getName().contains("$")) {
                result.add(field);
            }
        }
        return (Field[]) result.toArray(new Field[]{});
    }

    private Field[] getDeclaredFields(Object ref) {
        Class cls = ref.getClass();
        return cls.getDeclaredFields();
    }
}
// } OK ClassDataAbstractionCoupling - This class is basically a wirer / assembler.