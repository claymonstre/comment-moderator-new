package com.trgt.cmoderator.service;

import com.trgt.cmoderator.model.CommentFeedback;

public interface CommentValidatorService {

    CommentFeedback validateComment(String commentText);
}
