package com.project;

import java.io.Serializable;

/**
 *
 * @author armdev
 */
public class HashTag implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String hashtag;

    public HashTag(Long id, String hashtag) {
        this.id = id;
        this.hashtag = hashtag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

}
