package au.net.netstorm.boost.util.reflect;

import java.util.Map;

// FIXME: SC506 Sort out the constant crap.  Inline.
class TestSubjects {
    public static final Class TEST_INTERFACE_ONE = TestSubjects.TestInterfaceOne.class;
    public static final Class TEST_TWO_CONSTRUCTORS = TestSubjects.TestTwoConstructors.class;

    interface TestInterfaceOne {
        void fridayIsHere();

        Integer getSmeetOthEchuRchontIme(String frankyfurter, Map beanTypes);
    }

    interface TestInterfaceTwo {
        void crapola();
    }

    static final class TestNoPrivateConstructor {
        TestNoPrivateConstructor() { }
    }

    static final class TestOneInstanceFieldObject {
        private String field1 = "PAIR OR DIE";

        TestOneInstanceFieldObject(String value) {
            this.field1 = value;
        }

        public String toString() {
            return "I love checkstyle " + field1;
        }
    }

    static final class TestOnePrimitiveInstanceFieldObject {
        private final int field1;

        public TestOnePrimitiveInstanceFieldObject(int i) {
            this.field1 = i;
        }

        public String toString() {
            return "Lovely, lovely checkstyle " + field1;
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

        public String toString() {
            return "I love checkstyle " + STATIC_FIELD_1;
        }
    }

    static final class TestSinglePrivateConstructor {
        private TestSinglePrivateConstructor() { }
    }
}
