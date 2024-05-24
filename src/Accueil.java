import javafx.scene.layout.BorderPane;

public class Accueil extends BorderPane{
    

    public void start() {
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.titre());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }
}
