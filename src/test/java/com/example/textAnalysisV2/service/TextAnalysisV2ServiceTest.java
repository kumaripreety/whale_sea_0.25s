package com.example.textAnalysisV2.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import com.example.textAnalysisV2.model.TextAnalysisV2ResultModel;

public class TextAnalysisV2ServiceTest {
    private final TextAnalysisV2Service service = new TextAnalysisV2Service();

    @Test
    void testAnalyzeText2BasicText() throws Exception {

        String content = "Java is great. Java is powerful. Spring Boot is part of Java.";
        MockMultipartFile mockFile = new MockMultipartFile(content, "test.txt", "text/plain",
                content.getBytes(StandardCharsets.UTF_8));

        TextAnalysisV2ResultModel result = service.analyzeText(mockFile);
        assertEquals(7, result.getTotalWordCount());
        Map<String, Integer> topWords = result.getTopWords();
        assertEquals(3, topWords.get("Java".toLowerCase()));
        assertTrue(topWords.containsKey("Java".toLowerCase()));
        assertTrue(result.getUniqueWords().contains("Spring".toLowerCase()));

    }

    @Test
    void testAnalyzeTextV2WithStopWords() throws Exception {
        String content = "the and is on by in";
        MockMultipartFile mockFile = new MockMultipartFile("file", "stopwords.txt", "text/plain",
                content.getBytes(StandardCharsets.UTF_8));

        TextAnalysisV2ResultModel result = service.analyzeText(mockFile);

        assertNotNull(result);
        assertEquals(0, result.getTotalWordCount());
        assertTrue(result.getTopWords().isEmpty());
        assertTrue(result.getUniqueWords().isEmpty());
    }

}
