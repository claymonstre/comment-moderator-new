package com.trgt.cmoderator.model;

import java.util.List;

public class CommentFeedback {
    private List<String> badwordsUsed;
    private String category;
    private boolean isBadwordUsed;
    private String description;

    public List<String> getBadwordsUsed() {
        return badwordsUsed;
    }

    public void setBadwordsUsed(List<String> badwordsUsed) {
        this.badwordsUsed = badwordsUsed;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isBadwordUsed() {
        return !badwordsUsed.isEmpty();
    }

    public void setBadwordUsed(boolean badwordUsed) {
        isBadwordUsed = badwordUsed;
    }
}
