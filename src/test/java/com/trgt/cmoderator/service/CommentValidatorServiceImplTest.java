package com.trgt.cmoderator.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CommentValidatorServiceImplTest {

    private CommentValidatorServiceImpl commentValidatorService;

    @Before
    public void init() {
        commentValidatorService = new CommentValidatorServiceImpl();
    }

    @Test
    public void shouldReadBadwordsFromFile() {
        //TODO: add tests
    }
}
