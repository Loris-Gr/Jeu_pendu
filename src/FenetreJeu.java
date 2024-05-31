import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class FenetreJeu extends BorderPane{
    private Button boutonAccueil;
    private Button boutonParam;
    private Button boutonInfo;
    private MotMystere leMot;

    public FenetreJeu(Button boutonAccueil, Button boutonParam, Button boutonInfo, MotMystere leMot) {
        super();
        this.boutonAccueil = boutonAccueil;
        this.boutonParam = boutonParam;
        this.boutonInfo = boutonInfo;
        this.leMot = leMot;
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
        VBox vBox = new VBox();
        vBox.getChildren().add(new Label(this.leMot.getMotCrypte()));
        
    }


}
