package com.dharbor.set.social.comments.data.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author rveizaga
 */
public class UpdateMessageDTO extends CreateMessageDTO {

    @Getter
    @Setter
    private Date createdDate;

    @Getter
    @Setter
    private Boolean edited;

    @Getter
    @Setter
    private Date updatedDate;
}
