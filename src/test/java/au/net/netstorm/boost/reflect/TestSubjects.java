package au.net.netstorm.boost.reflect;

import java.util.Map;

class TestSubjects {
    interface TestInterfaceOne {
        void fridayIsHere();

        Integer getSmeetOthEchuRchontIme(String frankyfurter, Map beanTypes);
    }

    interface TestInterfaceTwo {
        void justSomeOldMethod();
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

    static final class TestOneConstructor {
        public TestOneConstructor() {
        }
    }

    static final class TestOnePrivateConstructor {
        private TestOnePrivateConstructor() {
        }
    }

    static final class TestTwoConstructors {
        private TestTwoConstructors() {
        }

        private TestTwoConstructors(String aString) {
        }
    }

    static final class TestThreeConstructors {
        private TestThreeConstructors() {
        }

        private TestThreeConstructors(String aString) {
        }

        private TestThreeConstructors(int anInt) {
        }
    }

    static final class TestZeroInstanceFieldsObject {
    }

    static final class TestZeroInstanceOneStaticFieldsObject {
        private static final String STATIC_FIELD_1 = "YO MAMA";
    }
}
