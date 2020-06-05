package com.dharbor.set.social.comments.data.domain;

import com.dharbor.set.social.comments.data.enums.Color;
import com.dharbor.set.social.comments.data.enums.ContentType;
import com.dharbor.set.social.comments.data.enums.Font;
import lombok.Data;

import java.util.Date;

/**
 * @author rveizaga
 */
@Data
public class Message {

    private Long id;

    private Explanation explanation;

    private String userId;

    private Date createdDate;

    private Date updatedDate;

    private ContentType contentType;

    private Boolean edited;

    private Color color;

    private Font font;
}
