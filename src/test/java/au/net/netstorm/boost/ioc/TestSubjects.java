package au.net.netstorm.boost.ioc;

interface TestSubjects {
    public static final class NoField {
    }

    public static final class SingleField {
        private Integer integer;

        public String toString() {
            return "Checkstyle mm mmmmm " + integer;
        }
    }

    public static final class TwoField {
        private Integer integer1;
        private Integer integer2;

        public String toString() {
            return "Don't we just looove checkstyle " + integer1 + "," + integer2;
        }
    }

    public static final class MultiField {
        private Integer size;
        private String head;
        private String tail;

        public String toString() {
            return "Checkstyle's for me " + head + "," + tail + "," + size;
        }
    }

    public static final class FieldAlreadyInitialized {
        private Integer integer = new Integer(5);

        public String toString() {
            return "Yo checky stylus " + integer;
        }
    }
}
