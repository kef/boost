package au.net.netstorm.boost.java.lang.reflect;

// FIXME: SC502 Test drive this.

public class MultipleConstructorsNotSupportedException extends RuntimeException {
    public MultipleConstructorsNotSupportedException(Class cls) {
        // FIXME: SC502 Is short name what we are after here?
        super("Multiple constructors not supported in " + new DefaultClassMaster().getShortName(cls), null);
    }
}
