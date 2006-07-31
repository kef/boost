package au.net.netstorm.boost.reflect;

// FIX SC502 Test drive this.

public class MultipleConstructorsNotSupportedException extends RuntimeException {
    public MultipleConstructorsNotSupportedException(Class cls) {
        // FIX SC502 Is short name what we are after here?
        super("Multiple constructors not supported in " + new DefaultClassMaster().getShortName(cls), null);
    }
}
