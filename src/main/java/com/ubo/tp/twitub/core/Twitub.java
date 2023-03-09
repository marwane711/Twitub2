package main.java.com.ubo.tp.twitub.core;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JMenuBar;
import javax.swing.JPanel;

import main.java.com.ubo.tp.twitub.controler.CtrlConnexion;
import main.java.com.ubo.tp.twitub.controler.CtrlInscription;
import main.java.com.ubo.tp.twitub.datamodel.ConsoleObserveur;
import main.java.com.ubo.tp.twitub.datamodel.Database;
import main.java.com.ubo.tp.twitub.datamodel.IDatabase;
import main.java.com.ubo.tp.twitub.datamodel.Twit;
import main.java.com.ubo.tp.twitub.datamodel.User;
import main.java.com.ubo.tp.twitub.events.file.IWatchableDirectory;
import main.java.com.ubo.tp.twitub.events.file.WatchableDirectory;
import main.java.com.ubo.tp.twitub.ihm.*;
import main.java.com.ubo.tp.twitub.observeurPattern.ObserveurInscription;
import main.java.com.ubo.tp.twitub.observeurPattern.ObserveurTwit;

/**
 * Classe principale l'application.
 * 
 * @author S.Lucas
 */
public class Twitub implements ObserveurInscription, ObserveurTwit {
	/**
	 * Base de données.
	 */
	protected IDatabase mDatabase;

	protected CtrlConnexion ctrlConnexion;

	protected VueConnexion vueConnexion;
	
	protected VueUserPage vueUser;
	
	protected VueAfficherTweet vueTwit;
	
	protected MenuConnecte vueMenuCo;
	
	protected JPanel vueCourante;

	protected CtrlInscription ctrlInscription;

	/**
	 * Gestionnaire des entités contenu de la base de données.
	 */
	protected EntityManager mEntityManager;

	/**
	 * Vue principale de l'application.
	 */
	protected TwitubMainFrame mMainView;

	/**
	 * Classe de surveillance de répertoire
	 */
	protected IWatchableDirectory mWatchableDirectory;

	/**
	 * Répertoire d'échange de l'application.
	 */
	protected String mExchangeDirectoryPath;

	/**
	 * Idnique si le mode bouchoné est activé.
	 */
	protected boolean mIsMockEnabled = true;

	protected VueSelecteurDeRepertoire mSelecteurDeFichier;

	/**
	 * Nom de la classe de l'UI.
	 */
	protected String mUiClassName;

	/**
	 * Constructeur.
	 */
	public Twitub() {
		// Init du look and feel de l'application
		this.initLookAndFeel();

		// Initialisation de la base de données
		this.initDatabase();

		if (this.mIsMockEnabled) {
			// Initialisation du bouchon de travail
			this.initMock();
		}

		this.ctrlInscription = new CtrlInscription(mDatabase, mEntityManager);
		
		this.vueUser = null;
		this.vueTwit = null;
		// Initialisation de l'IHM
		this.initGui();

		// Initialisation du selecteur de répertoire
		this.initSelecteurDeRepertoire();


		// Initialisation du répertoire d'échange
		this.initDirectory();
	}

	/**
	 * Initialisation du look and feel de l'application.
	 */
	protected void initLookAndFeel() {
	}

	/**
	 * Initialisation de l'interface graphique.
	 */
	protected void initGui() {
		// this.mMainView...
	}

	/**
	 * Initialisation du répertoire d'échange (depuis la conf ou depuis un file
	 * chooser). <br/>
	 * <b>Le chemin doit obligatoirement avoir été saisi et être valide avant de
	 * pouvoir utiliser l'application</b>
	 */
	protected void initDirectory() {
	}

	/**
	 * Indique si le fichier donné est valide pour servire de répertoire
	 * d'échange
	 * 
	 * @param directory
	 *            , Répertoire à tester.
	 */
	protected boolean isValideExchangeDirectory(File directory) {
		// Valide si répertoire disponible en lecture et écriture
		return directory != null && directory.exists() && directory.isDirectory() && directory.canRead()
				&& directory.canWrite();
	}

	/**
	 * Initialisation du mode bouchoné de l'application
	 */
	protected void initMock() {
		VueTwitubMock mock = new VueTwitubMock(this.mDatabase, this.mEntityManager);
		mock.showGUI();
	}

	protected void initMainView() {
		MenuDeconnecte menu = new MenuDeconnecte();
		this.mMainView = new TwitubMainFrame(menu);
		menu.addObservateur(this);
	}

	protected void initSelecteurDeRepertoire() {
		this.mSelecteurDeFichier = new VueSelecteurDeRepertoire(this.mEntityManager);
	}

	/**
	 * Initialisation de la base de données
	 */
	protected void initDatabase() {
		ConsoleObserveur console = new ConsoleObserveur();
		mDatabase = new Database();
		mDatabase.addObserver(console);
		mEntityManager = new EntityManager(mDatabase);
	}

	/**
	 * Initialisation du répertoire d'échange.
	 * 
	 * @param directoryPath
	 */
	public void initDirectory(String directoryPath) {
		mExchangeDirectoryPath = directoryPath;
		mWatchableDirectory = new WatchableDirectory(directoryPath);
		mEntityManager.setExchangeDirectory(directoryPath);

		mWatchableDirectory.initWatching();
		mWatchableDirectory.addObserver(mEntityManager);
	}

	public void show() {
		initMainView();
	}

	@Override
	public void updateConnexion() {
		this.ctrlConnexion = new CtrlConnexion(mDatabase);
		this.ctrlConnexion.addObservateur(this);
		vueConnexion = new VueConnexion(this.ctrlConnexion);
	}

	@Override
	public void updateInscription() {
		System.out.println("updateInscription");
		VueInscription vueInscription = new VueInscription(ctrlInscription);
	}

	@Override
	public void connecte(User user) {
		
		if(this.vueUser == null) {
			vueConnexion.dispose();
			this.vueUser = new VueUserPage(user);
			this.vueMenuCo = new MenuConnecte();
			this.vueMenuCo.addObservateur(this);
			this.vueMenuCo.addObserveur(this);
			this.vueUser.addObserveur(this);
			this.vueUser.addObservateur(this);
			mMainView.setJMenuBar(this.vueMenuCo);
		}
		vueCourante = vueUser;
		mMainView.addandvalide(vueCourante);
	}

	@Override
	public void updateVueTwits(Set<Twit> twits) {
		System.out.println("twit final");
		if(twits == null)
			twits = this.mDatabase.getTwits();
		
		this.vueTwit = new VueAfficherTweet(twits);
		this.vueTwit.addObserveur(this);
		this.vueCourante = this.vueTwit; 
		mMainView.addandvalide(this.vueCourante);
	}

	@Override
	public void newTwitSent(String text) {
		this.mDatabase.addTwit(new Twit(this.ctrlConnexion.getUser(), text));
		updateVueTwits(this.mDatabase.getTwits());
	}

	@Override
	public void myTwits() {
		System.out.println("myTwit");
		Set<Twit> mesTwits = new HashSet<Twit>();
		for(Twit t : this.mDatabase.getTwits()) {
			if(t.getTwiter().getName().equals(ctrlConnexion.getUser().getName())) {
				mesTwits.add(t);
			}
		}
		updateVueTwits(mesTwits);
	}

	@Override
	public void deconnecte() {
		this.vueUser = null;
		this.vueTwit = null;
		this.vueMenuCo = null;

		JPanel panelDeco = new JPanel();
		MenuDeconnecte menu = new MenuDeconnecte();
		menu.addObservateur(this);
		this.mMainView.setJMenuBar(menu);
		this.mMainView.addandvalide(panelDeco);
		this.vueCourante = panelDeco;
		
	}
}
