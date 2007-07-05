package au.net.netstorm.boost.demo.provider;

import au.net.netstorm.boost.util.type.Data;

public interface FunkyData extends Data {
    Righteous getRighteous();

    String getFunkyString(String string);

    String toString();
}
