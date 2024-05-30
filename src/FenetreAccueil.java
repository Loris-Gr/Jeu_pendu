import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleGroup;

public class FenetreAccueil extends BorderPane{
    private Button boutonAccueil;
    private Button boutonParam;
    private Button boutonInfo;
    private Button boutonPartie;
    private List<String> lesNiveaux;

    public FenetreAccueil(Button boutonAccueil, Button boutonParam, Button boutonInfo, Button boutonPartie, List<String> lesNiveaux) {
        super();
        this.boutonAccueil = boutonAccueil;
        this.boutonParam = boutonParam;
        this.boutonInfo = boutonInfo;
        this.boutonPartie = boutonPartie;
        this.lesNiveaux = lesNiveaux;

        this.setTop(hBoxTop());
        this.setCenter(vBoxCenter());
    }

    private HBox hBoxTop() {
        HBox hBoxTopp = new HBox();
        hBoxTopp.getChildren().add(new Label("Jeu du pendu"));
        HBox hBox = new HBox();
        hBox.getChildren().add(this.boutonAccueil);
        hBox.getChildren().add(this.boutonParam);
        hBox.getChildren().add(this.boutonInfo);
        hBoxTopp.getChildren().add(hBox);
        
        return hBoxTopp;
    }

    private VBox vBoxCenter() {
        VBox vBoxCenterr = new VBox();
        vBoxCenterr.getChildren().add(this.boutonPartie);
        TitledPane titledPane = new TitledPane("Niveau de difficulté", null);
        VBox vBox = new VBox();
        ToggleGroup toggleGroup = new ToggleGroup();
        List<RadioButton> laListe = new ArrayList<>();
    
        for (String niveau : this.lesNiveaux) {
            laListe.add(new RadioButton(niveau));
        }
        for (RadioButton radiobouton : laListe) {
            radiobouton.setToggleGroup(toggleGroup);
            vBox.getChildren().add(radiobouton);
        }
        titledPane.setContent(vBox);
        vBoxCenterr.getChildren().add(titledPane);

        return vBoxCenterr;

        /*
        RadioButton boutonFacile = new RadioButton("Facile");
        boutonFacile.setToggleGroup(toggleGroup);
        RadioButton boutonMedium = new RadioButton("Médium");
        boutonMedium.setToggleGroup(toggleGroup);
        RadioButton boutonDifficile = new RadioButton("Difficile");
        boutonDifficile.setToggleGroup(toggleGroup);
        RadioButton boutonExpert = new RadioButton("Expert");
        boutonExpert.setToggleGroup(toggleGroup);
         */

        





    }



    }

