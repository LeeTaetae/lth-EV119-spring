package com.app.ev119.api.publicApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/bot-api")
public class OpenAiAPI {

    @Value("${openai.api-key}")
    private String openaiApiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @PostMapping("/bot-json")
    public ResponseEntity<Map<String, Object>> chat(@RequestBody Map<String, String> request) {
        String message = request.get("message");

        log.info("Loaded openaiApiKey = {}", openaiApiKey);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(openaiApiKey);

        Map<String, Object> body = new HashMap<>();
        body.put("model", "gpt-4o-mini");
        body.put("messages", List.of(
                Map.of("role", "system", "content", """
                    JSON만 출력.
                    대처는 응급 상황에서 현장에서 응급처치로 할 수 있는 조치만
                    필드: keyword(string), urgency("medium"|"high"|"critical"), procedures(string[])
                    설명문 없이 오직 JSON만 출력.
                """),
                Map.of("role", "user", "content", message)
        ));

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        try {
            Map response = restTemplate.postForObject(
                "https://api.openai.com/v1/chat/completions",
                entity,
                Map.class
            );

            List choices = (List) response.get("choices");
            Map firstChoice = (Map) choices.get(0);
            Map messageObj = (Map) firstChoice.get("message");
            String content = (String) messageObj.get("content");

            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> finalJson = mapper.readValue(content, Map.class);

            return ResponseEntity.ok(finalJson);
        } catch (Exception e) {
            e.printStackTrace();
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "OpenAI API 요청 실패");
            errorResponse.put("apiKey", openaiApiKey);
            errorResponse.put("details", e.getMessage());
            return ResponseEntity.status(500).body(errorResponse);
        }

    }
}
