/*
 * package com.food.exp.controller;
 * 
 * import java.io.IOException; import java.io.InputStream; import
 * java.util.Scanner;
 * 
 * import org.springframework.core.io.ClassPathResource; import
 * org.springframework.core.io.Resource; import
 * org.springframework.core.io.ResourceLoader; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.ui.Model; import org.springframework.util.StreamUtils;
 * import org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.ResponseBody;
 * 
 * @Controller public class RegionController {
 * 
 * private final ResourceLoader resourceLoader;
 * 
 * public RegionController(ResourceLoader resourceLoader) { this.resourceLoader
 * = resourceLoader; }
 * 
 * @GetMapping("/regions")
 * 
 * @ResponseBody public ResponseEntity<String> getRegion(Model model) { try {
 * Resource resource = new ClassPathResource("region.json"); byte[] jsonData =
 * StreamUtils.copyToByteArray(resource.getInputStream()); String jsonString =
 * new String(jsonData); return ResponseEntity.ok(jsonString); } catch
 * (IOException e) { e.printStackTrace(); return
 * ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
 * body("Error occurred while fetching region data."); } // JSON 파일 읽기 try {
 * Resource resource = resourceLoader.getResource("classpath:region.json");
 * InputStream inputStream = resource.getInputStream(); String jsonString =
 * convertInputStreamToString(inputStream); // jsonString을 모델에 추가
 * model.addAttribute("jsonData", jsonString); } catch (IOException e) {
 * e.printStackTrace(); } }
 * 
 * private String convertInputStreamToString(InputStream inputStream) { try
 * (Scanner scanner = new Scanner(inputStream).useDelimiter("\\A")) { return
 * scanner.hasNext() ? scanner.next() : ""; } } }
 * 
 */