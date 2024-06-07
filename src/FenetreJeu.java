import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
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
    private MotMystere leMot;
    private ProgressBar pg;
    private ArrayList<Image> lesImages;
    private Clavier leClavier;
    private int nbEssai;

    public FenetreJeu(Button boutonAccueil, Button boutonParam, Button boutonInfo, MotMystere leMot, ProgressBar pg, ArrayList<Image> lesImages, Clavier leClavier) {
        super();
        this.boutonAccueil = boutonAccueil;
        this.boutonParam = boutonParam;
        this.boutonInfo = boutonInfo;
        this.leMot = leMot;
        this.pg = pg;
        this.lesImages = lesImages;
        this.leClavier = leClavier;
        this.nbEssai = 0;

        this.setTop(Top());
        this.setCenter(vBoxCenter());
        
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

    private VBox vBoxCenter() {
        VBox vBox = new VBox();
        vBox.getChildren().add(new Label(this.leMot.getMotCrypte()));
        Image imagePendu = lesImages.get(this.nbEssai);
        ImageView imagePenduConteneur = new ImageView(imagePendu);
        vBox.getChildren().add(imagePenduConteneur);
        vBox.getChildren().add(this.pg);
        vBox.getChildren().add(this.leClavier);
        return vBox;     
    }


}
