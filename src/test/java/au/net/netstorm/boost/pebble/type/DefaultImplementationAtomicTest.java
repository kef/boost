package au.net.netstorm.boost.pebble.type;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.test.automock.BoooostCase;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultImplementationAtomicTest extends BoooostCase {
    private static final Class[] STRING_INTERFACES = {CharSequence.class, Comparable.class, Serializable.class,};
    private static final Class[] HASH_MAP_INTERFACES = {Cloneable.class, Map.class, Serializable.class};
    // FIX 1715 Ensure it extends Primordial.  Or check two the same are equal.

    public void testImplementation() {
        checkImplementation(String.class, STRING_INTERFACES);
        checkImplementation(HashMap.class, HASH_MAP_INTERFACES);
    }

    private void checkImplementation(Class implementation, Class[] interfaces) {
        Implementation subject = new DefaultImplementation(implementation);
        Class result = subject.getImpl();
        assertEquals(implementation, result);
        Interface[] resultTypes = subject.getTypes();
        // FIX 1715 De-train wreck.
        assertBagEquals(buildInterfaces(interfaces), resultTypes);
    }

    private Interface[] buildInterfaces(Class[] ifaces) {
        int length = ifaces.length;
        Interface[] result = new Interface[length];
        for (int i = 0; i < length; i++) {
            result[i] = new DefaultInterface(ifaces[i]);
        }
        return result;
    }
    /*
                   ,#####,
                   #_   _#
                   |e` `e|
                   |  u  |
                   \  =  /
                   |\___/|
          ___ ____/:     :\____ ___
        .'   `.-===-\   /-===-.`   '.
       /      .-"""""-.-"""""-.      \
      /'             =:=             '\
    .'  ' .:    o   -=:=-   o    :. '  `.
    (.'   /'. '-.....-'-.....-' .'\   '.)
    /' ._/   ".       :       ."   \_. '\
   |  .'|      ".  ---:---  ."      |'.  |
   |  : |       |  ---:---  |       | :  |
    \ : |       |_____:_____|       | : /
    /   (       |----|------|       )   \
   /... .|      /`   |     '\      |. ...\
  |::::/''     /    .L__.    \     ''\::::|
   """"       /      / \      \       """"
             :      /   \      :
             |     /     \     |
             \    /       \    /
              )  |         |  (
             /   |         |   \
            (/\/\|         |/\/\)
             \  |           |  /
              ) |           | (
         _.-'`   \         /   `'-._
        :________/         \________;

         Domain Bastin Woz 'Ere 2007
     */
}
