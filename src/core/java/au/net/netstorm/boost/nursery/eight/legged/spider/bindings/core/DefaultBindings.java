package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.types.InjectionType;
import au.net.netstorm.boost.gunge.collection.IntegrityMap;
import au.net.netstorm.boost.gunge.collection.DefaultIntegrityMap;
import au.net.netstorm.boost.gunge.collection.Creator;
import au.net.netstorm.boost.gunge.collection.ArrayListCreator;

public final class DefaultBindings implements Bindings {
    // FIX 2394 MAG Dodgy line wrap ... or dodgy code.
    private final IntegrityMap<InjectionType,List<Binding>> bindings =
            new DefaultIntegrityMap<InjectionType, List<Binding>>();
    private final Creator<InjectionType, List<Binding>> creator = new ArrayListCreator<InjectionType, List<Binding>>();

    public void add(Binding binding) {
        InjectionType type = binding.getType();
        List<Binding> current = bindings.get(type, creator);
        current.add(binding);
    }

    public List<Binding> lookup(InjectionType type) {
        List<Binding> unsorted = bindings.get(type, creator);
        return sort(unsorted);
    }

    private List<Binding> sort(List<Binding> unsorted) {
        List<Binding> sorted = new ArrayList<Binding>(unsorted);
        Comparator<Binding> precedenceSort = new PrecedenceSort();
        Collections.sort(sorted, precedenceSort);
        return sorted;
    }
}
