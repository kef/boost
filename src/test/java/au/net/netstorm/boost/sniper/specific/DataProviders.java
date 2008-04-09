package au.net.netstorm.boost.sniper.specific;

import au.net.netstorm.boost.bullet.provider.SpecificProvider;
import au.net.netstorm.boost.gunge.type.Data;

public interface DataProviders extends SpecificProvider {
    <T extends Data> void add(Class<T> type, DataProvider provider);
}
