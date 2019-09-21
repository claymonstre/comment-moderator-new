package com.clay.cmoderator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FileWordLoaderTest {

    private FileWordLoader fileWordLoader;

    @Before
    public void init() {
        fileWordLoader = new FileWordLoader();
    }

    @Test
    public void shouldLoadAllWordsFromFile() {

        List<String> loadedWords = fileWordLoader.loadWords();

        assertNotNull(loadedWords);
        assertEquals(41, loadedWords.size());
    }
}
