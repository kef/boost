package au.net.netstorm.boost.reflect;

public class MultipleConstructorsNotSupportedException extends RuntimeException {
    private ClassMaster classMaster = new DefaultClassMaster();

    public MultipleConstructorsNotSupportedException(Class cls) {
        super("Multiple constructors not supported in " + classMaster.getShortName(cls), null);
    }
}
