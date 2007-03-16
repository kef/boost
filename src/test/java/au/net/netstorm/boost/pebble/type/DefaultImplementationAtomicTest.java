package au.net.netstorm.boost.pebble.type;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import au.net.netstorm.boost.primordial.Primordial;
import au.net.netstorm.boost.test.automock.BoooostCase;
import au.net.netstorm.boost.test.reflect.checker.ClassTestChecker;
import au.net.netstorm.boost.test.reflect.checker.DefaultClassTestChecker;
import au.net.netstorm.boost.util.type.DefaultInterface;
import au.net.netstorm.boost.util.type.Interface;

public final class DefaultImplementationAtomicTest extends BoooostCase {
    private static final Class[] STRING_INTERFACES = {CharSequence.class, Comparable.class, Serializable.class,};
    private static final Class[] HASH_MAP_INTERFACES = {Cloneable.class, Map.class, Serializable.class};
    private final ClassTestChecker classer = new DefaultClassTestChecker();

    public void testImplementation() {
        checkImplementation(String.class, STRING_INTERFACES);
        checkImplementation(HashMap.class, HASH_MAP_INTERFACES);
    }

    public void testFailsIfInterface() {
        try {
            new DefaultImplementation(YoInterface.class);
            fail();
        } catch (IllegalArgumentException expected) { }
    }

    public void testIs() {
        Implementation implementation = new DefaultImplementation(String.class);
        checkIs(true, implementation, Comparable.class);
        checkIs(false, implementation, Map.class);
    }

    private void checkIs(boolean expected, Implementation implementation, Class cls) {
        Interface iface = new DefaultInterface(cls);
        boolean actual = implementation.is(iface);
        assertEquals(expected, actual);
    }

    public void testPrimordial() {
        classer.checkSubclassOf(DefaultImplementation.class, Primordial.class);
    }

    private void checkImplementation(Class implementation, Class[] interfaces) {
        Implementation subject = new DefaultImplementation(implementation);
        checkImpl(subject, implementation);
        checkTypes(subject, interfaces);
    }

    private void checkTypes(Implementation subject, Class[] types) {
        Interface[] result = subject.getTypes();
        Interface[] expected = buildInterfaces(types);
        assertBagEquals(expected, result);
    }

    private void checkImpl(Implementation subject, Class impl) {
        Class result = subject.getImpl();
        assertEquals(impl, result);
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
