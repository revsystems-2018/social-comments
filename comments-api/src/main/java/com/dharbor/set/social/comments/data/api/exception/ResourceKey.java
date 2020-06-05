package com.dharbor.set.social.comments.data.api.exception;

/**
 * @author rveizaga
 */
public final class ResourceKey {

    private ResourceKey() {
        throw new IllegalStateException("Utility class");
    }

    public static final String EXPLANATION_BY_RESOURCE_NOT_FOUND = "EXPLANATION_BY_RESOURCE_NOT_FOUND";

    public static final String EXPLANATION_NOT_FOUND = "EXPLANATION_NOT_FOUND";

    public static final String MESSAGE_NOT_FOUND = "MESSAGE_NOT_FOUND";

    public static final String MESSAGE_OWNER_EXCEPTION = "MESSAGE_OWNER_EXCEPTION";

    public static final String TEXT_CONTENT_NOT_FOUND = "TEXT_CONTENT_NOT_FOUND";

    public static final String USER_NOT_FOUND = "USER_NOT_FOUND";
}
