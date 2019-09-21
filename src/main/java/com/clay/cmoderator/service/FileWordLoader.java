package com.clay.cmoderator.service;

import static com.clay.cmoderator.util.ValidationConstant.BAD_WORD_FILE_PATH;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FileWordLoader implements WordsLoader {

    private Logger log = LoggerFactory.getLogger(getClass());


    @Override
    public List<String> loadWords() {
        List<String> badwordDictionary = new ArrayList<>();
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
        return badwordDictionary;
    }
}
