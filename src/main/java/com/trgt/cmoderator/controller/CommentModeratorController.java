package com.trgt.cmoderator.controller;

import com.trgt.cmoderator.model.CommentFeedback;
import com.trgt.cmoderator.model.CustomerReviewComment;
import com.trgt.cmoderator.service.CommentValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/comment", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
        produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CommentModeratorController {

    @Autowired
    private CommentValidatorService commentValidatorService;

    @PostMapping(path = "/validate")
    public ResponseEntity<CommentFeedback> validateCustomerComment(@RequestBody CustomerReviewComment reviewComment) {

        return ResponseEntity.ok().body(commentValidatorService.validateComment(reviewComment.getComment()));
    }
}
