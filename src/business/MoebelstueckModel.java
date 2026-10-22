package business;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MoebelstueckModel {

	// speichert temporaer ein Objekt vom Typ Moebelstueck
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

		if ("csv".equals(typ)) {
			BufferedReader ein = new BufferedReader(new FileReader("Moebelstueck.csv"));
			String[] zeile = ein.readLine().split(";");
			this.moebelstueck = new Moebelstueck(zeile[0], zeile[1], zeile[2], Float.parseFloat(zeile[3]),
					zeile[4].split("_"));
			ein.close();

		} else {
			throw new Exception("Noch nicht implementiert!");
		}
	}

	public void schreibeMoebelstueckeInCsvDatei() throws Exception {

		BufferedWriter aus = new BufferedWriter(new FileWriter("MoebelstueckeAusgabe.csv", true));
		aus.write(moebelstueck.gibMoebelstueckZurueck(';'));
		aus.close();

	}

}
