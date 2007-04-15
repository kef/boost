package au.net.netstorm.boost.spider.inject.newer.field;

import au.net.netstorm.boost.util.type.Data;
import au.net.netstorm.boost.util.type.Implementation;
import au.net.netstorm.boost.util.type.Interface;

public interface NewerField extends Data {
    Interface getNewerInterface();

    Implementation getInstanceImplementation();

    String getFieldName();
}
