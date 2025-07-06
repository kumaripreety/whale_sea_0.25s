package com.example.textAnalysisV2.model;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TextAnalysisV2ResultModel {
    private long totalWordCount;
    private Map<String, Integer> topWords;
    private List<String> uniqueWords;
}
