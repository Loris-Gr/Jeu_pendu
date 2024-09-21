import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ButtonBar.ButtonData ;

import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;


/**
 * Vue du jeu du pendu
 */
public class Pendu extends Application {
    /**
     * modèle du jeu
     **/
    private MotMystere modelePendu;
    /**
     * Liste qui contient les images du jeu
     */
    private ArrayList<Image> lesImages;
    /**
     * Liste qui contient les noms des niveaux
     */    
    public List<String> niveaux;

    // les différents contrôles qui seront mis à jour ou consultés pour l'affichage
    /**
     * le dessin du pendu
     */
    private ImageView dessin;
    /**
     * le mot à trouver avec les lettres déjà trouvé
     */
    private String motCrypte;
    /**
     * la barre de progression qui indique le nombre de tentatives
     */
    private ProgressBar pg;
    /**
     * le clavier qui sera géré par une classe à implémenter
     */
    private Clavier clavier;
    /**
     * le text qui indique le niveau de difficulté
     */
    private String leNiveau;
    /**
     * le chronomètre qui sera géré par une clasee à implémenter
     */
    private Chronometre chrono;
    /**
     * le panel Central qui pourra être modifié selon le mode (accueil ou jeu)
     */
    private BorderPane panelCentral;
    /**
     * le bouton Paramètre / Engrenage
     */
    private Button boutonParametres;
    /**
     * le bouton Accueil / Maison
     */    
    private Button boutonMaison;
    /**
     * le bouton qui permet de (lancer ou relancer une partie
     */ 
    private Button bJouer;

    private Button boutonInfo;

    private Scene scene;

    private Stage stage;

    private FenetreAccueil laFenetreDAccueil;

    private FenetreJeu laFenetreDeJeu;

    /**
     * initialise les attributs (créer le modèle, charge les images, crée le chrono ...)
     */
    @Override
    public void init() {
        if (OSDetector.isWindows() || OSDetector.isMac()) {
            this.modelePendu = new MotMystere("ressources/liste_francais.txt", 3, 10, MotMystere.FACILE, 10);
        }
        else if (OSDetector.isUnix()) {
            this.modelePendu = new MotMystere("usr/share/dict/french", 3, 10, MotMystere.FACILE, 10);
        }
        this.motCrypte = modelePendu.getMotCrypte();
        this.lesImages = new ArrayList<Image>();
        this.chargerImages("./img");
        this.boutonMaison = new Button();
        Image imageMaison = new Image("file:img/home.png");
        ImageView imageMaisonConteneur = new ImageView(imageMaison);
        imageMaisonConteneur.setFitHeight(25);
        imageMaisonConteneur.setFitWidth(25);
        this.boutonMaison.setGraphic(imageMaisonConteneur);
        RetourAccueil controleurAccueil = new RetourAccueil(this.modelePendu, this);
        this.boutonMaison.setOnAction(controleurAccueil);

        this.boutonParametres= new Button();
        Image imageParametres = new Image("file:img/parametres.png");
        ImageView imageParametresConteneur = new ImageView(imageParametres);
        imageParametresConteneur.setFitHeight(25);
        imageParametresConteneur.setFitWidth(25);
        this.boutonParametres.setGraphic(imageParametresConteneur);


        this.boutonInfo = new Button();
        Image imageInfos = new Image("file:img/info.png");
        ImageView imageInfosConteneur = new ImageView(imageInfos);
        imageInfosConteneur.setFitHeight(25);
        imageInfosConteneur.setFitWidth(25);
        this.boutonInfo.setGraphic(imageInfosConteneur);
        ControleurInfos controleurInfos = new ControleurInfos(this);
        this.boutonInfo.setOnAction(controleurInfos);

        this.bJouer = new Button("Lancer une partie");
        ControleurLancerPartie controleurLancerPartie = new ControleurLancerPartie(this.modelePendu, this);
        this.bJouer.setOnAction(controleurLancerPartie);

        this.niveaux = new ArrayList<>();
        this.niveaux.add("Facile");
        this.niveaux.add("Medium");
        this.niveaux.add("Difficile");
        this.niveaux.add("Expert");

        this.pg = new ProgressBar(0);

        this.clavier = new Clavier("ABCDEFGHIJKLMNOPKRSTUVWXYZ-", new ControleurLettres(modelePendu, this));

        this.leNiveau = "Facile";

        this.chrono = new Chronometre();

        this.laFenetreDAccueil = new FenetreAccueil(this.boutonMaison, this.boutonParametres, this.boutonInfo, this.bJouer, this.modelePendu, this, this.niveaux);

        this.laFenetreDeJeu = new FenetreJeu(this.boutonMaison, this.boutonParametres, this.boutonInfo, this, this.leNiveau, this.modelePendu, this.pg, this.lesImages, this.clavier, this.chrono, this.motCrypte);



        
        Button boutonBack = new Button("Question précédente");
        
        // A terminer d'implementer
    }

    /**
     * @return  le graphe de scène de la vue à partir de methodes précédantes
     */
    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.titre());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
    }

    /**
     * @return le panel contenant le titre du jeu
     */
    private Pane titre(){
        // A implementer          
        Pane banniere = new Pane();
        return banniere;
    }

    // /**
     // * @return le panel du chronomètre
     // */
    // private TitledPane leChrono(){
        // A implementer
        // TitledPane res = new TitledPane();
        // return res;
    // }

    // /**
     // * @return la fenêtre de jeu avec le mot crypté, l'image, la barre
     // *         de progression et le clavier
     // */
    // private Pane fenetreJeu(){
        // A implementer
        // Pane res = new Pane();
        // return res;
    // }

    // /**
     // * @return la fenêtre d'accueil sur laquelle on peut choisir les paramètres de jeu
     // */
    // private Pane fenetreAccueil(){
        // A implementer    
        // Pane res = new Pane();
        // return res;
    // }

    /**
     * charge les images à afficher en fonction des erreurs
     * @param repertoire répertoire où se trouvent les images
     */
    private void chargerImages(String repertoire){
        for (int i=0; i<this.modelePendu.getNbErreursMax()+1; i++){
            File file = new File(repertoire+"/pendu"+i+".png");
            //System.out.println(file.toURI().toString());
            this.lesImages.add(new Image(file.toURI().toString()));
        }
    }

    public void modeAccueil(){
        this.scene.setRoot(this.laFenetreDAccueil);
    }
    
    public void modeJeu(){
        
    }
    
    public void modeParametres(){
        // A implémenter
    }

    /** lance une partie */
    public void lancePartie(){
        this.modelePendu.setMotATrouver();
        this.motCrypte = this.modelePendu.getMotCrypte();
        this.clavier.restart();
        this.chrono.resetTime();
        this.chrono.start();
        this.pg.setProgress(0);
        this.laFenetreDeJeu.reset(this.leNiveau, this.modelePendu, this.pg, this.clavier, this.chrono, this.motCrypte);
        this.scene.setRoot(this.laFenetreDeJeu);
    }

    /**
     * raffraichit l'affichage selon les données du modèle
     */
    public void majAffichage(){
        this.motCrypte = this.modelePendu.getMotCrypte();
        int nbErreursRestantes = this.modelePendu.getNbErreursRestants();
        int nbErreurs = this.modelePendu.getNbErreursMax()-nbErreursRestantes;
        double progress = (double) nbErreurs / this.modelePendu.getNbErreursMax();
        this.pg.setProgress(progress);
        this.clavier.desactiveTouches(this.modelePendu.getLettresEssayees());
        this.laFenetreDeJeu.maj(this.modelePendu, this.pg, this.clavier, this.chrono, this.motCrypte, nbErreurs);
        
        if (this.modelePendu.gagne()) {
            this.popUpMessageGagne().show();
            this.modeAccueil();
        } 
        else if (this.modelePendu.perdu()) {
            this.popUpMessagePerdu().show();
            this.modeAccueil();
        }
    }

    /**
     * accesseur du chronomètre (pour les controleur du jeu)
     * @return le chronomètre du jeu
     */
    public Chronometre getChrono(){
        return this.chrono; 
    }

    public void changerNiveau(int niveau) {
        //fonction pour actualiser le this.leNiveau
        if (niveau == 0) {
            this.leNiveau = "Facile";
        }
        if (niveau == 1) {
            this.leNiveau = "Medium";
        }
        if (niveau == 2) {
            this.leNiveau = "Difficile";
        }
        if (niveau == 3) {
            this.leNiveau = "Expert";
        }
    }

    public Alert popUpPartieEnCours(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"La partie est en cours!\n Etes-vous sûr de l'interrompre ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }

    public Alert popUpNouvellePartie() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Voulez-vous lancez une partie en " + this.leNiveau + " ?", ButtonType.YES, ButtonType.NO);
        alert.setTitle("Attention");
        return alert;
    }
        
    public Alert popUpReglesDuJeu(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Voilà plein d'infos !");
        alert.setTitle("INFORMATIONS");
        alert.setHeaderText("Voilà les règles du jeu");
        return alert;
    }
    
    public Alert popUpMessageGagne(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vous avez gagné, bravo ! Le mot était bien " + this.modelePendu.getMotATrouve()); 
        alert.setTitle("INFORMATIONS");
        alert.setHeaderText("Bravo !");       
        return alert;
    }
    
    public Alert popUpMessagePerdu(){    
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Vous avez perdu, dommage. Le mot était " + this.modelePendu.getMotATrouve());
        alert.setTitle("INFORMATIONS");
        alert.setHeaderText("Dommage !");
        return alert;
    }


    @Override
    public void start(Stage stage) {
        this.stage = stage;
        this.stage.setTitle("IUTEAM'S - La plateforme de jeux de l'IUTO");
        this.scene = this.laScene();
        this.stage.setScene(scene);
        this.modeAccueil();
        this.stage.show();
    }

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    }    
}
