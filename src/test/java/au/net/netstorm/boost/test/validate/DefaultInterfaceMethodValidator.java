package au.net.netstorm.boost.test.validate;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import au.net.netstorm.boost.reflect.DefaultReflectMaster;
import au.net.netstorm.boost.reflect.ReflectMaster;

public final class DefaultInterfaceMethodValidator implements InterfaceMethodValidator {
    private final ReflectMaster reflectMaster = new DefaultReflectMaster();

    public void validate(Object ref) {
        validate(ref, new MethodMatcher[0]);
    }

    public void validate(Object ref, MethodMatcher allowed) {
        MethodMatcher[] matchers = new MethodMatcher[]{allowed};
        validate(ref, matchers);
    }

    public void validate(Object ref, MethodMatcher[] allowed) {
        Class[] ifaces = ref.getClass().getInterfaces();
        Map interfaceMethods = interfaceSignatures(ifaces);
        Map objectMethods = implementationSignatures(ref);
        removeImpelmented(interfaceMethods, objectMethods);
        checkLeftoversAllowed(objectMethods, allowed);
    }

    private Map interfaceSignatures(Class[] ifaces) {
        Map methodMap = new HashMap();
        for (int i = 0; i < ifaces.length; i++) {
            Method[] methods = ifaces[i].getMethods();
            Map signatureMap = implementationSignatures(methods);
            methodMap.putAll(signatureMap);
        }
        return methodMap;
    }

    private Map implementationSignatures(Object ref) {
        Method[] methods = reflectMaster.getPublicMethods(ref);
        return implementationSignatures(methods);
    }

    private Map implementationSignatures(Method[] methods) {
        Map signatureMap = new HashMap();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            MethodSignature signature = new DefaultMethodSignature(method);
            signatureMap.put(signature, method);
        }
        return signatureMap;
    }

    private void removeImpelmented(Map interfaceMethods, Map objectMethods) {
        Set signatures = interfaceMethods.keySet();
        for (Iterator iterator = signatures.iterator(); iterator.hasNext();) {
            Object iFaceSignature = iterator.next();
            objectMethods.remove(iFaceSignature);
        }
    }

    private void checkLeftoversAllowed(Map signatureMap, MethodMatcher[] allowed) {
        Collection methods = signatureMap.values();
        for (Iterator iterator = methods.iterator(); iterator.hasNext();) {
            Method method = (Method) iterator.next();
            if (!isAllowed(allowed, method))
                throw new ValidationException("Method '" + method + "' is not defined in an interface.");
        }
    }

    private boolean isAllowed(MethodMatcher[] allowed, Method method) {
        for (int i = 0; i < allowed.length; i++) {
            if (allowed[i].matches(method)) return true;
        }
        return false;
    }
}
