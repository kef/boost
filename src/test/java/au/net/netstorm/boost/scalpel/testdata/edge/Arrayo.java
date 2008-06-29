package au.net.netstorm.boost.scalpel.testdata.edge;

import au.net.netstorm.boost.scalpel.core.Edge;

public interface Arrayo extends Edge {
    ArrayElement[] single();
    ArrayElement[][] multi();
    au.net.netstorm.boost.scalpel.testdata.real.ArrayElement[] real();
}
