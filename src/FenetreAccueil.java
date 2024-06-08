import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
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
    private MotMystere modelePendu;
    private Pendu lePendu;
    private HBox hBox;
    private List<String> lesNiveaux;

    public FenetreAccueil(Button boutonAccueil, Button boutonParam, Button boutonInfo, Button boutonPartie, MotMystere modelePendu, Pendu lePendu, List<String> lesNiveaux) {
        super();
        this.boutonAccueil = boutonAccueil;
        this.boutonParam = boutonParam;
        this.boutonInfo = boutonInfo;
        this.boutonPartie = boutonPartie;
        this.modelePendu = modelePendu;
        this.lesNiveaux = lesNiveaux;
        this.lePendu = lePendu;
        this.hBox = new HBox();

        this.setTop(Top());
        this.setCenter(vBoxCenter());
    }

   
    private BorderPane Top() {
        BorderPane bpTop = new BorderPane();
        bpTop.setPadding(new Insets(20));
        Label titre = new Label("Jeu du pendu");
        titre.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        bpTop.setLeft(titre);
        this.hBox.getChildren().add(this.boutonAccueil);
        this.hBox.getChildren().add(this.boutonParam);
        this.hBox.getChildren().add(this.boutonInfo);
        bpTop.setRight(this.hBox);
        
        return bpTop;
    }

    private VBox vBoxCenter() {
        VBox vBoxCenterr = new VBox();
        vBoxCenterr.setSpacing(30);
        vBoxCenterr.getChildren().add(this.boutonPartie);
        TitledPane titledPane = new TitledPane("Niveau de difficulté", null);
        VBox vBox = new VBox();
        ToggleGroup toggleGroup = new ToggleGroup();
        List<RadioButton> laListe = new ArrayList<>();
    
        for (String niveau : this.lesNiveaux) {
            laListe.add(new RadioButton(niveau));
        }
        int i = 0;
        for (RadioButton radiobouton : laListe) {
            radiobouton.setToggleGroup(toggleGroup);
            radiobouton.setOnAction(new ControleurNiveau(this.modelePendu, i, this.lePendu));
            vBox.getChildren().add(radiobouton);
            i++;
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

