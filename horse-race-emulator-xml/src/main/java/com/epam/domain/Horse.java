package com.epam.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Horse {

  private String name;
  private Rider rider;
  private Breed breed;

  @Override
  public String toString(){
    return name + " " + rider.getName() + " " + breed.getName();
  }

}
