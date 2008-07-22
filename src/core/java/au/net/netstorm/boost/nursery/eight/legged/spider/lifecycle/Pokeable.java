package au.net.netstorm.boost.nursery.eight.legged.spider.lifecycle;

// FIX 2394 This is a spike to test different lifecycle semantics to constructable:
// FIX 2394          #poke() is repeatable with out side-effects.
// FIX 2394 may not have a long life, just seeing how it works out
public interface Pokeable {
    void poke();
}
