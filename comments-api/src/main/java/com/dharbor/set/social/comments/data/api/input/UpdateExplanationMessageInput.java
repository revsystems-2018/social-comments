package com.dharbor.set.social.comments.data.api.input;

import com.dharbor.set.social.comments.data.enums.Color;
import com.dharbor.set.social.comments.data.enums.Font;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author rveizaga
 */
@Getter
@Setter
public class UpdateExplanationMessageInput {

    @NotNull
    @NotBlank
    private String content;

    private Color color;

    private Font font;

}
