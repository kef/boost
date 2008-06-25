package au.net.netstorm.boost.nursery.eight.legged.spider.bindings.binder;

import au.net.netstorm.boost.nursery.eight.legged.spider.bindings.core.MutableBinding;

public final class DefaultSingleMaker implements SingleMaker {
    private final MutableBinding binding;

    public DefaultSingleMaker(MutableBinding binding) {
        this.binding = binding;
    }

    public void asSingle() {
        binding.makeSingleton();
    }
}