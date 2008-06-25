package au.net.netstorm.boost.nursery.eight.legged.spider.factory.supplied;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public final class DefaultMappings implements Mappings {
    private final List<Mapping> mappers = new ArrayList<Mapping>();

    public void add(Mapping mapper) {
        mappers.add(mapper);
    }

    public Iterator<Mapping> iterator() {
        return mappers.iterator();
    }
}