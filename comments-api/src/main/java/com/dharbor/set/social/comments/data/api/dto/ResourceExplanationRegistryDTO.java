package com.dharbor.set.social.comments.data.api.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @author rveizaga
 */
public class ResourceExplanationRegistryDTO {

    @Getter
    @Setter
    private String resourceId;

    @Getter
    @Setter
    private String resourceName;

    @Getter
    @Setter
    private String resourceValue;
}
