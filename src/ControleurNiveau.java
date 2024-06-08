import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

/**
 * Controleur des radio boutons gérant le niveau
 */
public class ControleurNiveau implements EventHandler<ActionEvent> {

    /**
     * modèle du jeu
     */
    private MotMystere modelePendu;
    private int niveau;
    private Pendu lePendu;


    /**
     * @param modelePendu modèle du jeu
     */
    public ControleurNiveau(MotMystere modelePendu, int niveau, Pendu lePendu) {
        this.modelePendu = modelePendu;
        this.niveau = niveau;
        this.lePendu = lePendu;
    }

    /**
     * gère le changement de niveau
     * @param actionEvent
     */
    @Override
    public void handle(ActionEvent actionEvent) {
        RadioButton radiobouton = (RadioButton) actionEvent.getTarget();
        String nomDuRadiobouton = radiobouton.getText();
        this.modelePendu.setNiveau(this.niveau);
        this.lePendu.changerNiveau(this.niveau);
        System.out.println(nomDuRadiobouton);
        System.out.println(this.niveau);   
    }
}
