package fileCreatorsDaoud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderProductB extends ReaderProductDaoud {

	private BufferedReader reader;

	public ReaderProductB() throws IOException {
		reader = new BufferedReader(new FileReader("Moebelstuecke.txt"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String[] ergebnisZeile = new String[5];
		String zeile = reader.readLine();
		int i = 0;
		while (i < ergebnisZeile.length && zeile != null) {
			ergebnisZeile[i] = zeile;
			zeile = reader.readLine();
			i++;
		}

		return ergebnisZeile;
	}

	@Override
	public void schliesseDatei() throws IOException {
		reader.close();
	}
}
