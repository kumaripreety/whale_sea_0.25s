package com.example.textAnalysisV2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.textAnalysisV2.model.TextAnalysisV2ResultModel;
import com.example.textAnalysisV2.service.TextAnalysisV2Service;

@RestController
@RequestMapping("api/v2/text")
public class TextAnalysisV2Controller {
    @Autowired
    private TextAnalysisV2Service service;

    @PostMapping(value = "/analyze", consumes = org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<TextAnalysisV2ResultModel> analyzeTextFile(@RequestParam("file") MultipartFile file) throws Exception {
        TextAnalysisV2ResultModel result = service.analyzeText(file);
        return ResponseEntity.ok(result);
    }

}
