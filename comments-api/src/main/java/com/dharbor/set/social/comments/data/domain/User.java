package com.dharbor.set.social.comments.data.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author rveizaga
 */
@Data
public class User {

    private String id;

    private String userName;

    private String firstName;

    private String lastName;

    private String email;

    private Boolean enabled;
}
