package au.net.netstorm.boost.demo.immutable;

import au.net.netstorm.boost.gunge.type.Data;

public interface Work extends Data {
    Host host();

    Port port();
}
