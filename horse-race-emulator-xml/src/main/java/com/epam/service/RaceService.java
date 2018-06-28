package com.epam.service;

import com.epam.domain.Horse;
import com.epam.domain.Race;
import java.util.List;
import lombok.Setter;

public class RaceService {

  {
    System.out.println("Race service invoked");
  }

  @Setter
  private HorseService horseService;

  public Race getRace() {
    List<Horse> horses = horseService.getHorses();
    return Race.builder().horses(horses).build();
  }
}
