package com.clay.cmoderator.service;

import com.clay.cmoderator.model.CommentFeedback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    final private List<String> badwordDictionary = new ArrayList<>();
    private static final String BAD_WORD_FILE_PATH = "src/test/resources/static/badwords.txt";
    private static final String BLANK_SPACE = " ";

    @Override
    public CommentFeedback validateComment(String comment) {
        loadBadwords();

        String filteredComment = comment.trim()
                .replaceAll("[^a-zA-Z\\s]", "")
                .replaceAll(" +", BLANK_SPACE)
                .toLowerCase();
        CommentFeedback commentFeedback = new CommentFeedback();

        List<String> usedBadwords = Stream.of(filteredComment.split(BLANK_SPACE))
                .filter(badwordDictionary::contains)
                .collect(Collectors.toList());

        commentFeedback.setIncludedBadwords(usedBadwords);
        commentFeedback.setCategory("Profanity");

        return commentFeedback;
    }

    protected void loadBadwords() {
        try {
            List<String> badwords = Files.readAllLines(Paths.get(BAD_WORD_FILE_PATH));
            badwordDictionary.addAll(
                    badwords.stream()
                            .map(word -> word.toLowerCase())
                            .collect(Collectors.toList())
            );
        } catch (IOException e) {
            log.error("Error while reading file {}", e.getMessage());
        }
    }
}
