package au.net.netstorm.boost.nursery.eight.legged.spider.rules.declaration;

import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.Matcher;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.HostMatcher;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.NameMatcher;
import au.net.netstorm.boost.nursery.eight.legged.spider.rules.matchers.MultiMatcher;

public final class DefaultMultiplicityOrScope implements MultiplicityOrScope {
    private final RuleBuilder builder;

    public DefaultMultiplicityOrScope(RuleBuilder builder) {
        this.builder = builder;
    }

    public void asSingle() {
        builder.setIsSingleton(true);
    }

    public void asMulti() {
        builder.setIsSingleton(false);
    }

    public Multiplicity in(Class<?> host, String name) {
        Matcher hostMatcher = new HostMatcher(host);
        Matcher nameMatcher = new NameMatcher(name);
        Matcher matcher = new MultiMatcher(hostMatcher, nameMatcher);
        return setScope(matcher);
    }

    public Multiplicity in(Class<?> host) {
        Matcher matcher = new HostMatcher(host);
        return setScope(matcher);
    }

    public Multiplicity in(String name) {
        Matcher matcher = new NameMatcher(name);
        return setScope(matcher);
    }

    private Multiplicity setScope(Matcher matcher) {
        builder.setScope(matcher);
        return this;
    }
}
