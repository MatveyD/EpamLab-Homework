package com.epam.service;

import com.epam.domain.Breed;
import com.epam.domain.Horse;
import java.util.ArrayList;
import java.util.List;
import lombok.Setter;

@Setter

public class HorseService {

  private List<Horse> horses;

  private void fillHorses(){
    Breed first = Breed.builder().name("breed1").build();

  }

  public List<Horse> getHorses() {
    List<Horse> allHorses = new ArrayList<>(horses.size());
    allHorses.addAll(horses);
    return allHorses;
  }
}
