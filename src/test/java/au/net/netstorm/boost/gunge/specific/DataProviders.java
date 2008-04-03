package au.net.netstorm.boost.gunge.specific;

import au.net.netstorm.boost.provider.SpecificProvider;
import au.net.netstorm.boost.util.type.Data;

public interface DataProviders extends SpecificProvider {
    <T extends Data> void add(Class<T> type, DataProvider provider);
}
