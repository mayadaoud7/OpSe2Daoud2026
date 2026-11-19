package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorsDaoud.ConcreteCreatorAB;
import fileCreatorsDaoud.ReaderCreatorDaoud;
import fileCreatorsDaoud.ReaderProductDaoud;

public class MoebelstueckModel {

	private Moebelstueck moebelstueck;

	public MoebelstueckModel() {
	}

	public Moebelstueck getMoebelstueck() {
		return moebelstueck;
	}

	public void setMoebelstueck(Moebelstueck moebelstueck) {
		this.moebelstueck = moebelstueck;
	}

	public void leseAusDatei(String typ) throws IOException, Exception {

		if (!"csv".equals(typ) && !"txt".equals(typ)) {
			throw new Exception("Noch nicht implementiert!");

		}

		ReaderCreatorDaoud creator = new ConcreteCreatorAB();

		ReaderProductDaoud reader = creator.factoryMethod(typ);
		String[] zeile = reader.leseAusDatei();

		this.moebelstueck = new Moebelstueck(zeile[0], zeile[1], zeile[2], Float.parseFloat(zeile[3]),
				zeile[4].split("_"));

		reader.schliesseDatei();

	}

	public void schreibeMoebelstueckeInCsvDatei() throws Exception {

		BufferedWriter aus = new BufferedWriter(new FileWriter("MoebelstueckeAusgabe.csv", true));
		aus.write(moebelstueck.gibMoebelstueckZurueck(';'));
		aus.close();

	}

}
