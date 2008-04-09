package au.net.netstorm.boost.nursery.edgify;

import java.io.File;
import au.net.netstorm.boost.edge.EdgeException;
import au.net.netstorm.boost.gunge.array.ArrayMaster;
import au.net.netstorm.boost.gunge.array.DefaultArrayMaster;
import au.net.netstorm.boost.sniper.aggregator.DefaultFileSystemLocator;
import au.net.netstorm.boost.sniper.aggregator.FileSystemLocator;
import au.net.netstorm.boost.sniper.aggregator.RegexPattern;
import au.net.netstorm.boost.sniper.aggregator.TestClassLocator;
import au.net.netstorm.boost.sniper.aggregator.TestRegexPattern;
import au.net.netstorm.boost.sniper.core.BoooostCase;

// OK ClassDataAbstractionCoupling {
public final class EdgeCheckerModuleTest extends BoooostCase {
    private final FileSystemLocator fileLocator = new DefaultFileSystemLocator();
    private final ArrayMaster array = new DefaultArrayMaster();
    private final TestClassLocator classLocator = new TestClassLocator();
    private final EdgeChecker constructorChecker = new DefaultEdgeConstructorChecker();
    private final EdgeChecker fieldChecker = new DefaultEdgeFieldChecker();
    private final EdgeChecker classChecker = new DefaultEdgeClassChecker();
    private final EdgeChecker edgifierChecker = new DefaultEdgeEdgifierChecker();
    private final EdgeChecker parameterChecker = new DefaultEdgeParameterChecker();
    private final EdgeChecker packageChecker = new DefaultEdgePackageChecker("com.whatever.");
    private Class[] edgeClasses;

    protected void gearup() {
        Class[] startingWithEdge = getClasses(".*DefaultEdge.*");
        Class[] endingWithSupplier = getClasses(".*Supplier");
        Class[] endingWithConverter = getClasses(".*Converter");
        Class[] endingWithChecker = getClasses(".*Checker");
        Class[] excludingSuppliers = array.minus(startingWithEdge, endingWithSupplier);
        Class[] excludingCheckers = array.minus(excludingSuppliers, endingWithChecker);
        edgeClasses = array.minus(excludingCheckers, endingWithConverter);
    }

    public void testEdgeStructure() {
        for (int i = 0; i < edgeClasses.length; i++) {
            checkStructure(edgeClasses[i]);
        }
    }

    private void checkStructure(Class edgeClass) {
        constructorChecker.check(edgeClass);
        fieldChecker.check(edgeClass);
        classChecker.check(edgeClass);
        edgifierChecker.check(edgeClass);
        parameterChecker.check(edgeClass);
        packageChecker.check(edgeClass);
    }

    private Class[] getClasses(String regex) {
        RegexPattern pattern = new TestRegexPattern(regex);
        File root = fileLocator.locate(EdgeException.class);
        return classLocator.locate(root, pattern);
    }
}
// } OK ClassDataAbstractionCoupling