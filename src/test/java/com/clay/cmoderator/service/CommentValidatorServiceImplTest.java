package com.clay.cmoderator.service;

import com.clay.cmoderator.model.CommentFeedback;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommentValidatorServiceImplTest {

    private CommentValidatorServiceImpl commentValidatorService;

    @Before
    public void init() {
        commentValidatorService = new CommentValidatorServiceImpl();
    }

    @Test
    public void shouldRecogniseBadwordsFromComment() {

        String comment = "Damn it, this product is goddamn bad.";

        CommentFeedback commentFeedback = commentValidatorService.validateComment(comment);

        Assert.assertNotNull(commentFeedback);
        Assert.assertEquals("Profanity", commentFeedback.getCategory());
        Assert.assertEquals(true, commentFeedback.isBadwordUsed());
        Assert.assertEquals("damn", commentFeedback.getIncludedBadwords().get(0));
        Assert.assertEquals("goddamn", commentFeedback.getIncludedBadwords().get(1));
    }

    @Test
    public void shouldIgnoreNonBadwords() {

        String comment = "This product works like charm";

        CommentFeedback commentFeedback = commentValidatorService.validateComment(comment);

        Assert.assertNotNull(commentFeedback);
        Assert.assertEquals(false, commentFeedback.isBadwordUsed());
        Assert.assertEquals(0, commentFeedback.getIncludedBadwords().size());
    }
}
