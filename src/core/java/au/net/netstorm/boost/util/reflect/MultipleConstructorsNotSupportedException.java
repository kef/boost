package au.net.netstorm.boost.util.reflect;

import au.net.netstorm.boost.util.reflect.DefaultClassMaster;
import au.net.netstorm.boost.ioc.IocException;

public class MultipleConstructorsNotSupportedException extends IocException {
    public MultipleConstructorsNotSupportedException(Class cls) {
        super("Multiple constructors not supported in " + new DefaultClassMaster().getShortName(cls), null);
    }
}
