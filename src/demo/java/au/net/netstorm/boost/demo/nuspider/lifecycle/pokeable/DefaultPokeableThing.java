package au.net.netstorm.boost.demo.nuspider.lifecycle.pokeable;

public final class DefaultPokeableThing implements PokeableSingle, PokeableMulti {
    private int count = 0;

    public int pokeCount() {
        return count;
    }

    public void poke() {
        ++count;
    }
}
