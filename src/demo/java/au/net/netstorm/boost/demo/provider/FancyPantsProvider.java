package au.net.netstorm.boost.demo.provider;

import static au.net.netstorm.boost.demo.provider.FancyPants.JUMP_SUIT;
import au.net.netstorm.boost.test.specific.DataProvider;

public class FancyPantsProvider implements DataProvider<FancyPants> {
    public FancyPants get() {
        return JUMP_SUIT;
    }
}
