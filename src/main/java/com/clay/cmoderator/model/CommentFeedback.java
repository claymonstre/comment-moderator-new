package com.clay.cmoderator.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentFeedback {
    private List<String> includedBadwords;
    private String category;
    private boolean isBadwordUsed;

    public List<String> getIncludedBadwords() {
        return includedBadwords;
    }

    public void setIncludedBadwords(List<String> includedBadwords) {
        this.includedBadwords = includedBadwords;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isBadwordUsed() {
        return !includedBadwords.isEmpty();
    }

    public void setBadwordUsed(boolean badwordUsed) {
        isBadwordUsed = badwordUsed;
    }

}
