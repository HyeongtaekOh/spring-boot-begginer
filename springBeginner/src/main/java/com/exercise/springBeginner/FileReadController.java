package com.exercise.springBeginner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileReadController {

  @GetMapping("/read-file")
  public List<Map<String, Object>> getAllUpcomingGames() {
    ClassPathResource resource = new ClassPathResource("static/data/upcoming games.txt");

    List<Map<String, Object>> games = new ArrayList<>();
    try {
      Path path = Paths.get(resource.getURI());
      List<String> content = Files.readAllLines(path);
      if (content.get(0) == null) {
        System.out.println("Failed to read first line.");
        return null;
      }
      String[] keys = content.get(0).split("\\s+");
      for (int j = 1; j < content.size(); j++) {
        String[] values = content.get(j).split("\\s+");
        Map<String, Object> game = new HashMap<>();
        for (int i = 0; i < 4; i++) {
          game.put(keys[i], values[i]);
        }

        games.add(game);
      }

      return games;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }
}
