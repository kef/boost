package au.net.netstorm.boost.nursery.eight.legged.spider.injection.injectors;

import au.net.netstorm.boost.nursery.eight.legged.spider.injection.graph.InjectionContext;

public final class DefaultMemberInjector implements MemberInjector {
    private final MemberInjector[] members;

    public DefaultMemberInjector(MemberInjector[] members) {
        this.members = members;
    }

    public void inject(InjectionContext context, Object ref) {
        for (MemberInjector member : members) member.inject(context, ref);
    }
}
