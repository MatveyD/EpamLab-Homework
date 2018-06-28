package com.epam.service;

import com.epam.domain.Horse;
import com.epam.domain.Race;
import java.util.Collections;
import java.util.Random;

public class EmulationService {

  final int MAX_DISTATION = 10;
  final int MIN_DISTATION = 2;

  public Horse emulate(Race race) {

    if (race == null || race.getHorses() == null) {
      throw new IllegalArgumentException("horse list is empty");
    }

    Random random = new Random();

    int parts = random.nextInt(MAX_DISTATION - MIN_DISTATION) + MIN_DISTATION;

    for (int i = 0; i < parts; i++) {
      emulateState(race);
      //printState(race);
    }

    return race.getHorses().get(0);
  }

  private void emulateState(Race race){
    Collections.shuffle(race.getHorses(), new Random());
  }

//  private void printState(Race race){
//    for (Horse : race.getHorses()){
//    }
//  }
}
