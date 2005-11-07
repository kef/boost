package au.net.netstorm.boost.util.reflect;

import java.util.Map;

// FIXME: SC506 Sort out the constant crap.  Inline.
// FIXME: SC502 Remove any unused classes from here.
class TestSubjects {
    public static final Class TEST_INTERFACE_ONE = TestSubjects.TestInterfaceOne.class;
    public static final Class TEST_TWO_CONSTRUCTORS = TestSubjects.TestTwoConstructors.class;

    interface TestInterfaceOne {
        void fridayIsHere();

        Integer getSmeetOthEchuRchontIme(String frankyfurter, Map beanTypes);
    }

    interface TestInterfaceTwo {
        void justSomeOldMethod();
    }

    static final class TestNoPrivateConstructor {
        TestNoPrivateConstructor() { }
    }

    static final class TestOneInstanceFieldObject {
        private String value = "PAIR OR QUAD";

        TestOneInstanceFieldObject(String value) {
            this.value = value;
        }
    }

    static final class TestOnePrimitiveInstanceFieldObject {
        private final int value;

        public TestOnePrimitiveInstanceFieldObject(int i) {
            this.value = i;
        }
    }

    static final class TestThreeConstructors {
        private TestThreeConstructors() { }

        private TestThreeConstructors(String aString) { }

        private TestThreeConstructors(int anInt) { }
    }

    static final class TestTwoConstructors {
        private TestTwoConstructors() { }

        private TestTwoConstructors(String aString) { }
    }

    static final class TestZeroInstanceFieldsObject {
    }

    static final class TestZeroInstanceOneStaticFieldsObject {
        private static final String STATIC_FIELD_1 = "YO MAMA";
    }

    static final class TestSinglePrivateConstructor {
        private TestSinglePrivateConstructor() { }
    }
}
