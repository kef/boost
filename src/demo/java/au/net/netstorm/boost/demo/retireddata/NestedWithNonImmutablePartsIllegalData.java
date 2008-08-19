package au.net.netstorm.boost.demo.retireddata;

import au.net.netstorm.boost.bullet.primordial.Primordial;

final class NestedWithNonImmutablePartsIllegalData extends Primordial implements NestedNonImmutableInterface {
    private final String guitar;
    private final NonImmutableInterface nonImmutable;

    public NestedWithNonImmutablePartsIllegalData(String guitar, NonImmutableInterface nonImmutable) {
        this.guitar = guitar;
        this.nonImmutable = nonImmutable;
    }

    public String getGuitar() {
        return guitar;
    }

    public NonImmutableInterface getNonImmutable() {
        return nonImmutable;
    }
}
