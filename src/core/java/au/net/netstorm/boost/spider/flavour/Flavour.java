package au.net.netstorm.boost.spider.flavour;

import au.net.netstorm.boost.util.type.Data;

public interface Flavour extends Data {
    Flavour UNFLAVOURED = new DefaultFlavour("Like XXXX ... totally unflavoured");

    String getValue();
}
