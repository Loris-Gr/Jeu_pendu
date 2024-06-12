import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class FenetreJeu extends BorderPane{
    private Button boutonAccueil;
    private Button boutonParam;
    private Button boutonInfo;
    private Pendu lePendu;
    private String leNiveau;
    private MotMystere modelePendu;
    private ProgressBar pg;
    private ArrayList<Image> lesImages;
    private Clavier leClavier;
    private Chronometre chrono;
    private int nbEssai;
    private String motCrypte;

    public FenetreJeu(Button boutonAccueil, Button boutonParam, Button boutonInfo, Pendu lePendu, String leNiveau, MotMystere modelePendu, ProgressBar pg, ArrayList<Image> lesImages, Clavier leClavier, Chronometre chrono, String motCrypte) {
        super();
        this.boutonAccueil = boutonAccueil;
        this.boutonParam = boutonParam;
        this.boutonInfo = boutonInfo;
        this.lePendu = lePendu;
        this.leNiveau = leNiveau;
        this.modelePendu = modelePendu;
        this.pg = pg;
        this.lesImages = lesImages;
        this.leClavier = leClavier;
        this.chrono = chrono;
        this.motCrypte = motCrypte;
        this.nbEssai = 0;

        this.setTop(Top());
        this.setCenter(vBoxCenter());
        this.setRight(vBoxRight());
        
    }

    private BorderPane Top() {
        BorderPane bpTop = new BorderPane();
        HBox hBox = new HBox();
        bpTop.setPadding(new Insets(20));
        Label titre = new Label("Jeu du pendu");
        titre.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        bpTop.setLeft(titre);
        hBox.getChildren().add(this.boutonAccueil);
        hBox.getChildren().add(this.boutonParam);
        hBox.getChildren().add(this.boutonInfo);
        bpTop.setRight(hBox);
        return bpTop;
    }

    public VBox vBoxCenter() {
        VBox vBox = new VBox();
        vBox.setSpacing(30);
        Label motCrypte = new Label(this.modelePendu.getMotCrypte());
        motCrypte.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        vBox.getChildren().add(motCrypte);
        Image imagePendu = lesImages.get(this.nbEssai);
        ImageView imagePenduConteneur = new ImageView(imagePendu);
        vBox.getChildren().add(imagePenduConteneur);
        vBox.getChildren().add(this.pg);
        vBox.getChildren().add(this.leClavier);
        return vBox;     
    }

    private VBox vBoxRight() {
        VBox vBox = new VBox();
        vBox.setSpacing(30);
        Label labelNiveau = new Label("Niveau " + this.leNiveau);
        labelNiveau.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        vBox.getChildren().add((labelNiveau));
        TitledPane titledPane = new TitledPane("Chronomètre", null);
        titledPane.setContent(this.chrono);
        vBox.getChildren().add(titledPane);
        Button boutonNouveauMot = new Button("Nouveau mot");
        boutonNouveauMot.setOnAction(new ControleurLancerPartie(this.modelePendu, this.lePendu));
        vBox.getChildren().add(boutonNouveauMot);
        return vBox;
    }

    public void reset(String leNiveau, MotMystere modelePendu, ProgressBar pg, Clavier clavier, Chronometre chrono, String motCrypte) {
        this.leNiveau = leNiveau;
        this.modelePendu = modelePendu;
        this.pg = pg;
        this.leClavier = clavier;
        this.chrono = chrono;
        this.motCrypte = motCrypte;
        this.nbEssai = 0;
        this.setCenter(vBoxCenter());
        this.setRight(vBoxRight());
    }

    public void maj(MotMystere modelePendu, ProgressBar pg, Clavier clavier, Chronometre chrono, String motCrypte, int nbErreurs) {
        this.modelePendu = modelePendu;
        this.pg = pg;
        this.leClavier = clavier;
        this.chrono = chrono;
        this.motCrypte = motCrypte;
        this.nbEssai = nbErreurs;

        this.setCenter(vBoxCenter());
    }

    public void ajoutEssai() {
        this.nbEssai+=1;
    }
}
