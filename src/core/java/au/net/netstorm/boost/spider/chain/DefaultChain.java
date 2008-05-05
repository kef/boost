package au.net.netstorm.boost.spider.chain;

import au.net.netstorm.boost.bullet.primmm.Primordial;
import au.net.netstorm.boost.gunge.type.Implementation;
import au.net.netstorm.boost.gunge.type.Interface;

public final class DefaultChain extends Primordial implements Chain {
    private final Interface type;
    private final Implementation[] links;

    public DefaultChain(Interface type, Implementation[] links) {
        validate(type);
        validate(links);
        this.type = type;
        this.links = links.clone();
    }

    public Interface getType() {
        return type;
    }

    public Implementation[] getLinks() {
        return links.clone();
    }

    private void validate(Object ref) {
        if (ref == null) throw new IllegalArgumentException();
    }
}
