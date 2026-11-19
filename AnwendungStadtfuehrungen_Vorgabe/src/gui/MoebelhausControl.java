package gui;

import business.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MoebelhausControl {

	private MoebelhausView view;
	private MoebelstueckModel model;

	public MoebelhausControl(Stage primaryStage) {

		this.model = new MoebelstueckModel();
		this.view = new MoebelhausView(this, primaryStage, this.model);

	}

	public void nehmeMoebelstueckAuf(String name, String wohnraum, String stil, String preis, String materialien) {
		try {
			Moebelstueck m = new Moebelstueck(name, wohnraum, stil, Float.parseFloat(preis), materialien.split(";"));
			this.model.setMoebelstueck(m);
			this.view.zeigeInformationsfensterAn("Das Moebelstueck wurde aufgenommen!");
		} catch (Exception exc) {
			this.view.zeigeFehlermeldungsfensterAn(exc.getMessage());
		}
	}

	public void leseAusDatei(String typ) {
		try {

			model.leseAusDatei(typ);
			view.zeigeInformationsfensterAn("Die Moebelstueck wurde gelesen!");


		} catch (IOException exc) {
			view.zeigeFehlermeldungsfensterAn("IOException beim Lesen!");

		} catch (Exception exc) {
			view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!");
		}
	}

	public void schreibeMoebelstueckeInCsvDatei() {
		try {

			model.schreibeMoebelstueckeInCsvDatei();
			view.zeigeInformationsfensterAn("Die Moebelstuecke wurden gespeichert!");
		} catch (IOException exc) {
			view.zeigeFehlermeldungsfensterAn("IOException beim Speichern!");
		} catch (Exception exc) {
			view.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!");
		}
	}

}
