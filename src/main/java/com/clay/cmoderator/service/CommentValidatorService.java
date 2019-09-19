package com.clay.cmoderator.service;

import com.clay.cmoderator.model.CommentFeedback;

public interface CommentValidatorService {

    CommentFeedback validateComment(String commentText);
}
