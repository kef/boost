package au.net.netstorm.boost.spider.registry;

import au.net.netstorm.boost.nursery.spider.registry.Linkage;

// FIX ()   2237 Factory looks exactly like BlueprintRead.  Rationalise by deleting this.
public final class BlueprintedFactory implements Factory {
    private final BlueprintsRead blueprintsRead;

    public BlueprintedFactory(BlueprintsRead blueprintsRead) {
        this.blueprintsRead = blueprintsRead;
    }

    public Blueprint get(Linkage linkage) {
        return blueprintsRead.get(linkage);
    }

    // FIX ()   2237 Add host.  Or remove from above method.
    // FIX ()   2237 Actually, don't add host here, but keep it in get().
    // FIX () BREADCRUMB   2237 AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
    public boolean canHandle(Linkage linkage) {
        return blueprintsRead.exists(linkage);
    }
}
