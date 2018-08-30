package com.derteuffel;

import com.derteuffel.entities.Personnel;
import com.derteuffel.ressources.PersonelRessources;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by derteuffel on 30/08/2018.
 */

@Service
public class ServiceLayer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceLayer.class);

    @Autowired
    private PersonelRessources personelRessources;


    @EventListener(ApplicationReadyEvent.class)
    public void initializeTestData() {
        LOGGER.info("Initialize test data");


  //      personelRessources.addPersonnel(new Personnel("afana", "rene", "666666", "17N54", "ingenieur", "", new Date(), "", "", "", new Date(), "en fonction"));
    //    personelRessources.addPersonnel(new Personnel("Metou", "rene", "666666", "17N54", "developpeur", "", new Date(), "", "", "", new Date(), "en fonction"));
      //  personelRessources.addPersonnel(new Personnel("Nkomozo", "rene", "666666", "17N54", "ingenieur", "", new Date(), "", "", "", new Date(), "affecter"));
        //personelRessources.addPersonnel(new Personnel("Mr le nye", "rene", "666666", "17N54", "ingenieur", "", new Date(), "", "", "", new Date(), "en fonction"));

        LOGGER.info("Initialize test completed");

    }
}
