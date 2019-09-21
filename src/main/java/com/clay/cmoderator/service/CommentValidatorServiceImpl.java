package com.clay.cmoderator.service;

import static com.clay.cmoderator.util.ValidationConstant.BAD_WORD_FILE_PATH;
import static com.clay.cmoderator.util.ValidationConstant.BLANK_SPACE;

import com.clay.cmoderator.model.CommentFeedback;
import com.clay.cmoderator.util.ValidationConstant;
import com.clay.cmoderator.util.ValidatorUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CommentValidatorServiceImpl implements CommentValidatorService {

    private Logger log = LoggerFactory.getLogger(getClass().getName());

    private List<String> badwordDictionary = new ArrayList<>();

    private FileWordLoader fileWordLoader;

    CommentValidatorServiceImpl(FileWordLoader fileWordLoader){
        this.fileWordLoader =  fileWordLoader;
    }

    @Override
    public CommentFeedback validateComment(String comment) {
        //loadBadwords();
        badwordDictionary = fileWordLoader.loadWords();

        String filteredComment = ValidatorUtil.filterComment(comment);
        CommentFeedback commentFeedback = new CommentFeedback();

        List<String> usedBadwords = Stream.of(filteredComment.split(BLANK_SPACE))
                .filter(badwordDictionary::contains)
                .collect(Collectors.toList());

        commentFeedback.setIncludedBadwords(usedBadwords);
        commentFeedback.setCategory("Profanity");

        return commentFeedback;
    }
}
