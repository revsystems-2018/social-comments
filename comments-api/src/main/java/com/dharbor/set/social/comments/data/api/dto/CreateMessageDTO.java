package com.dharbor.set.social.comments.data.api.dto;

import com.dharbor.set.social.comments.data.domain.Explanation;
import com.dharbor.set.social.comments.data.enums.Color;
import com.dharbor.set.social.comments.data.enums.ContentType;
import com.dharbor.set.social.comments.data.enums.Font;
import lombok.Getter;
import lombok.Setter;

/**
 * @author rveizaga
 */
public class CreateMessageDTO {

    @Getter
    @Setter
    private Explanation explanation;

    @Getter
    @Setter
    private String userId;

    @Getter
    @Setter
    private ContentType contentType;

    @Getter
    @Setter
    private Color color;

    @Getter
    @Setter
    private Font font;
}
