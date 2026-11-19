package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import fileCreatorsDaoud.ConcreteCreatorAB;
import fileCreatorsDaoud.ReaderCreatorDaoud;
import fileCreatorsDaoud.ReaderProductDaoud;

public class MoebelstueckModel {

	private Moebelstueck moebelstueck;

	private ReaderCreatorDaoud creator;
	private ReaderProductDaoud product; 
	
	public MoebelstueckModel() {
	}

	public Moebelstueck getMoebelstueck() {
		return moebelstueck;
	}

	public void setMoebelstueck(Moebelstueck moebelstueck) {
		this.moebelstueck = moebelstueck;
	}

	public void leseAusDatei(String typ) throws IOException, Exception {


		creator = new ConcreteCreatorAB();

		product = creator.factoryMethod(typ);
		String[] zeile = product.leseAusDatei();

		this.moebelstueck = new Moebelstueck(zeile[0], zeile[1], zeile[2], Float.parseFloat(zeile[3]), zeile[4].split("_"));

		product.schliesseDatei();

	}

	public void schreibeMoebelstueckeInCsvDatei() throws Exception {

		BufferedWriter aus = new BufferedWriter(new FileWriter("MoebelstueckeAusgabe.csv", true));
		aus.write(moebelstueck.gibMoebelstueckZurueck(';'));
		aus.close();

	}

}
