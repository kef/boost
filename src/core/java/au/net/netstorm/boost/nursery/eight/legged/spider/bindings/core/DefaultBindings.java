package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.nursery.eight.legged.spider.collections.IntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.collections.DefaultIntegrityMap;
import au.net.netstorm.boost.nursery.eight.legged.spider.collections.Creator;
import au.net.netstorm.boost.nursery.eight.legged.spider.collections.ArrayListCreator;

public final class DefaultBindings implements Bindings {
    private final IntegrityMap<InjectionType,List<Binding>> bindings =
            new DefaultIntegrityMap<InjectionType, List<Binding>>();
    private final Creator<InjectionType, List<Binding>> creator = new ArrayListCreator<InjectionType, List<Binding>>();

    public void add(Binding binding) {
        InjectionType type = binding.getType();
        List<Binding> current = bindings.getOrCreate(type, creator);
        current.add(binding);
    }

    public List<Binding> lookup(InjectionType type) {
        List<Binding> unsorted = bindings.getOrCreate(type, creator);
        return sort(unsorted);
    }

    private List<Binding> sort(List<Binding> unsorted) {
        List<Binding> sorted = new ArrayList<Binding>(unsorted);
        Comparator<Binding> precedenceSort = new PrecedenceSort();
        Collections.sort(sorted, precedenceSort);
        return sorted;
    }
}
