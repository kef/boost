package au.net.netstorm.boost.spider.inject.newer.field;

import java.lang.reflect.Field;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultNewerFieldAssembler implements NewerFieldAssembler {
    private final ClassToNuAssembler classtoNuAssembler = new DefaultClassToNuAssembler();

    public NewerField assemble(Field field) {
        Class newerType = field.getType();
        Interface newerInterface = new DefaultInterface(newerType);
        Implementation classToNu = classtoNuAssembler.assemble(newerType);
        String fieldName = field.getName();
        return new DefaultNewerField(newerInterface, classToNu, fieldName);
    }
}
