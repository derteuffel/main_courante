package com.derteuffel;

import com.derteuffel.entities.*;
import com.derteuffel.ressources.*;
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

    @Autowired
    private MaterielRessources materielRessources;
    @Autowired
    EnginRessources enginRessources;

    @Autowired
    private ArmementRessources armementRessources;

    @Autowired
    private Autre_MaterielRessources autre_materielRessources;


    @EventListener(ApplicationReadyEvent.class)
    public void initializeTestData() {
        LOGGER.info("Initialize test data");


  //      personelRessources.addPersonnel(new Personnel("afana", "rene", "666666", "17N54", "ingenieur", "", new Date(), "", "", "", new Date(), "en fonction"));
    //    personelRessources.addPersonnel(new Personnel("Metou", "rene", "666666", "17N54", "developpeur", "", new Date(), "", "", "", new Date(), "en fonction"));
      //  personelRessources.addPersonnel(new Personnel("Nkomozo", "rene", "666666", "17N54", "ingenieur", "", new Date(), "", "", "", new Date(), "affecter"));
        //personelRessources.addPersonnel(new Personnel("Mr le nye", "rene", "666666", "17N54", "ingenieur", "", new Date(), "", "", "", new Date(), "en fonction"));


        enginRessources.saveEngin(new Engin("toyota","voiture","rouge","decharger","N124","4 palces","23541287"));
        enginRessources.saveEngin(new Engin("hyunday","voiture","rouge","stocker","N124","4 palces","23541287"));

        armementRessources.saveArmement(new Armement("pistolet","arme a feu","noir","decharge","1245M","canon 128mm",new Integer(123)));
        armementRessources.saveArmement(new Armement("carabine","arme a feu","noir","decharge","1245M","canon 128mm",new Integer(125)));
        armementRessources.saveArmement(new Armement("40a80","arme a feu","bleu","stocker","1245M","canon 1200mm",new Integer(122)));
        armementRessources.saveArmement(new Armement("pistolet","lance requette","noir","stocker","1245M","canon 128mm",new Integer(121)));


        autre_materielRessources.saveAutre_Materiel(new Autre_Materiel("couteau","arme blanche","gris","stocker","147","egorgeur"));
        autre_materielRessources.saveAutre_Materiel(new Autre_Materiel("couteau","arme blanche","gris","stocker","147","egorgeur"));
        autre_materielRessources.saveAutre_Materiel(new Autre_Materiel("couteau","arme blanche","gris","stocker","147","egorgeur"));

        LOGGER.info("Initialize test completed");

    }
}
