package com.clay.cmoderator.controller;

import com.clay.cmoderator.model.CommentFeedback;
import com.clay.cmoderator.model.CustomerReviewComment;
import com.clay.cmoderator.service.CommentValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/comment")
public class CommentModeratorController {

    @Autowired
    private CommentValidatorService commentValidatorService;

    @PostMapping(path = "/validate")
    public ResponseEntity<CommentFeedback> validateCustomerComment(@RequestBody CustomerReviewComment reviewComment) {

        return ResponseEntity.ok()
                .body(commentValidatorService
                        .validateComment(reviewComment.getComment()));
    }
}
