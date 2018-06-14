package com.epam;

import com.epam.domain.Horse;
import com.epam.service.HorseService;
import java.util.List;
import lombok.Setter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Setter
public class Application {

  public static void main(String[] args) {

    ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
    HorseService horseService = (HorseService) context.getBean("horseService");

    List<Horse> horses = horseService.getHorses();

    for (Horse horse: horses){
      System.out.println(horse);
    }

    //Horse horse = (Horse) context.getBean("sparky");
    //System.out.println(horse);

  }


}