package au.net.netstorm.boost.demo.data;

import au.net.netstorm.boost.gunge.type.Data;

interface NestedInterface extends Data {
    String getGuitar();

    BasicInterface getBasic();
}
