package au.net.netstorm.boost.nursery.pebble.create;

// FIX 1665 Ensure naming works.  If a field is call fooCreator chuck a wobbly.
// FIX 1665 Close down scope.  Make package-private.
public class Fred {
    private final NewTed newTedNotACreatorField = null;
    private NewNed newNedNotACreatorField = new NewNed();
    private NewNed newNed;
    private NewTed newTed;
    private String notACreatorField;

    private class NewTed {
    }

    private class NewNed {
    }
}
