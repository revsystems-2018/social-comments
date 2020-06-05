package com.dharbor.set.social.comments.data.domain;

import lombok.Getter;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rveizaga
 */
public class Pagination<T> {

    @Getter
    private List<T> collection;

    @Getter
    private PageMetadata pageMetadata;

    public Pagination(PagedResources<T> pagedResources) {
        this.collection = new ArrayList<>(pagedResources.getContent());
        this.pageMetadata = pagedResources.getMetadata();
    }
}
