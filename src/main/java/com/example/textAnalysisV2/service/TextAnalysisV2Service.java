package com.example.textAnalysisV2.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.textAnalysisV2.model.TextAnalysisV2ResultModel;
import com.example.textAnalysisV2.util.ExclusionWords;

@Service
public class TextAnalysisV2Service {
    private static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z]+");

    public TextAnalysisV2ResultModel analyzeText(MultipartFile file) throws Exception {
        Map<String, Integer> wordCount = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {

                // remove 's
                line = line.toLowerCase().replaceAll("'s\\b", ""); 

                // split on non-word characters
                String[] words = line.split("\\W+"); 
                for (String word : words) {
                    if (!word.isBlank() && WORD_PATTERN.matcher(word).matches() && !(ExclusionWords.EXCLUSIONS.contains(word))) {
                        wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }
        catch (Exception ex){
            throw new IOException("Failed to read the uploaded file. Please check the file format or contents.", ex);
        }

        long totalWordCount = wordCount.values().stream().mapToLong(i -> i).sum();

        // Sort once 1st priority count and 2nd priority alphabetically
        List<Map.Entry<String, Integer>> sortedEntries = wordCount.entrySet().stream()
            .sorted((word1, word2) -> {
                int val = word2.getValue().compareTo(word1.getValue());
                return val == 0 ? word1.getKey().compareTo(word2.getKey()) : val;
            })
            .collect(Collectors.toList());

        // Get top 5 words with count
        Map<String, Integer> topWords = sortedEntries.stream()
            .limit(5)
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x1, x2) -> x1, LinkedHashMap::new));

        // Get top 50 unique words
        List<String> uniqueWords = sortedEntries.stream()
            .limit(50)
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        return new TextAnalysisV2ResultModel(totalWordCount, topWords, uniqueWords);
    }
}

