package au.net.netstorm.boost.ioc;

import au.net.netstorm.boost.util.reflect.DefaultClassMaster;

public class MultipleConstructorsNotSupportedException extends IocException {
    public MultipleConstructorsNotSupportedException(Class cls) {
        super("Multiple constructors not supported in " + new DefaultClassMaster().getShortName(cls), null);
    }
}
