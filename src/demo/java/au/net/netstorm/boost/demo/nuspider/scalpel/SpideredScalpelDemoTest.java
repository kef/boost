package au.net.netstorm.boost.demo.nuspider.scalpel;

import au.net.netstorm.boost.demo.nuspider.test.NuSpiderDemooooTest;
import au.net.netstorm.boost.sniper.marker.InjectableTest;
import au.net.netstorm.boost.spider.core.Nu;
import demo.edge.java.lang.Integer;

public final class SpideredScalpelDemoTest extends NuSpiderDemooooTest implements InjectableTest {
   Nu nu;

   public void testNu() {
       Integer i1 = nu.nu(Integer.class, 5);
       Integer i2 = nu.nu(Integer.class, 5);
       assertEquals(5, i1.intValue());
       assertEquals(5, i2.intValue());
       assertEquals(i1, i2);
   }
}