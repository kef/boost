package au.net.netstorm.boost.spider.inject.newer.field;

import java.lang.reflect.Field;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerFieldBuilder implements NewerFieldBuilder {
    private final ClassToNuBuilder classtoNuBuilder = new DefaultClassToNuBuilder();

    public NewerField build(Field field) {
        Class newerType = field.getType();
        Interface newerInterface = new DefaultInterface(newerType);
        Implementation classToNu = classtoNuBuilder.build(newerType);
        String fieldName = field.getName();
        return new DefaultNewerField(newerInterface, classToNu, fieldName);
    }
}
