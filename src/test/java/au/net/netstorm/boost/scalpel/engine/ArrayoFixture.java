package au.net.netstorm.boost.scalpel.engine;

import au.net.netstorm.boost.sledge.java.lang.reflect.Method;

public interface ArrayoFixture {
    Method edgedMulti();

    Method edgedSingle();

    Method edgedReal();

    Method realMulti();

    Method badEdgedMulti();
}
