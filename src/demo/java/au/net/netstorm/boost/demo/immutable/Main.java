package au.net.netstorm.boost.demo.immutable;

import au.net.netstorm.boost.nursery.eight.legged.spider.builder.DefaultSpiderEgg;
import au.net.netstorm.boost.nursery.eight.legged.spider.builder.SpiderEgg;
import au.net.netstorm.boost.spider.core.Spider;

// FIX 2130 Migrate to a "demo" test.
public final class Main {
    private final Spider spider = spider();

    private void main() {
        Example example = spider.nu(Example.class);
        example.example();
    }

    public static void main(String[] args) {
        new Main().main();
    }

    Spider spider() {
        SpiderEgg egg = new DefaultSpiderEgg();
        return egg.hatch(ImmutablesConfig.class);
    }
}
