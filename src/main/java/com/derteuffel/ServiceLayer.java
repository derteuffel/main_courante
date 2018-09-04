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

    @Autowired
    private SuspectRessources suspectRessources;

    @Autowired
    private RequerantRessources requerantRessources;

    @Autowired
    private EquipeRessources equipeRessources;

    @Autowired
    private EvenementRessources evenementRessources;

    @Autowired
    private UserRessources userRessources;


    @EventListener(ApplicationReadyEvent.class)
    public void initializeTestData() {
        LOGGER.info("Initialize test data");
/*evenementRessources.save(new Evenement("en123","nature","saisine","lieu","commentaire","type", new Date()));
        evenementRessources.save(new Evenement("124","nature","saisine","lieu","commentaire","type", new Date()));
        evenementRessources.save(new Evenement("sqhjds","nature","saisine","lieu","commentaire","type", new Date()));
        evenementRessources.save(new Evenement("csdkjklù","nature","saisine","lieu","commentaire","type", new Date()));
        evenementRessources.save(new Evenement("dkjfz","nature","saisine","lieu","commentaire","type", new Date()));
        evenementRessources.save(new Evenement("kezfj","nature","saisine","lieu","commentaire","type", new Date()));
        evenementRessources.save(new Evenement("zkejfi","nature","saisine","lieu","commentaire","type", new Date()));

        equipeRessources.save(new Equipe(new String[]{"dbjkfhsf", "hjfhjs","dfssdjhds"},"14521","25447","kdjshjkhf"));
        equipeRessources.save(new Equipe(new String[]{"dbjkfhsf", "hjfhjs","dfssdjhds"},"14521","25447","kdjshjkhf"));
        equipeRessources.save(new Equipe(new String[]{"dbjkfhsf", "hjfhjs","dfssdjhds"},"14521","25447","kdjshjkhf"));

        suspectRessources.save(new Suspect("dfsdf","sdssff","cdsfsf","zffeff","dssfsfdf","sdffdfs",new Date(),"sdffsf",
                "fsfddf","dfsdf","sdssff","cdsfsf","zffeff","dssfsfdf","sdffdfs","sdffsf","dfsdf","sdssff","cdsfsf"));

        suspectRessources.save(new Suspect("dfsdf","sdssff","cdsfsf","zffeff","dssfsfdf","sdffdfs",new Date(),"sdffsf",
                "fsfddf","dfsdf","sdssff","cdsfsf","zffeff","dssfsfdf","sdffdfs","sdffsf","dfsdf","sdssff","cdsfsf"));

        suspectRessources.save(new Suspect("dfsdf","sdssff","cdsfsf","zffeff","dssfsfdf","sdffdfs",new Date(),"sdffsf",
                "fsfddf","dfsdf","sdssff","cdsfsf","zffeff","dssfsfdf","sdffdfs","sdffsf","dfsdf","sdssff","cdsfsf"));

        suspectRessources.save(new Suspect("dfsdf","sdssff","cdsfsf","zffeff","dssfsfdf","sdffdfs",new Date(),"sdffsf",
                "fsfddf","dfsdf","sdssff","cdsfsf","zffeff","dssfsfdf","sdffdfs","sdffsf","dfsdf","sdssff","cdsfsf"));
*/



       /* enginRessources.saveEngin(new Engin("toyota","voiture","rouge","decharger","N124","4 palces","23541287"));
        enginRessources.saveEngin(new Engin("hyunday","voiture","rouge","stocker","N124","4 palces","23541287"));

        armementRessources.saveArmement(new Armement("pistolet","arme a feu","noir","decharge","1245M","canon 128mm",new Integer(123)));
        armementRessources.saveArmement(new Armement("carabine","arme a feu","noir","decharge","1245M","canon 128mm",new Integer(125)));
        armementRessources.saveArmement(new Armement("40a80","arme a feu","bleu","stocker","1245M","canon 1200mm",new Integer(122)));
        armementRessources.saveArmement(new Armement("pistolet","lance requette","noir","stocker","1245M","canon 128mm",new Integer(121)));


        autre_materielRessources.saveAutre_Materiel(new Autre_Materiel("couteau","arme blanche","gris","stocker","147","egorgeur"));
        autre_materielRessources.saveAutre_Materiel(new Autre_Materiel("couteau","arme blanche","gris","stocker","147","egorgeur"));
        autre_materielRessources.saveAutre_Materiel(new Autre_Materiel("couteau","arme blanche","gris","stocker","147","egorgeur"));*/

        LOGGER.info("Initialize test completed");

    }
}
