package fileCreatorsDaoud;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderProductA extends ReaderProductDaoud {

	private BufferedReader reader;

	public ReaderProductA() throws IOException {
		reader = new BufferedReader(new FileReader("Moebelstueck.csv"));
	}

	@Override
	public String[] leseAusDatei() throws IOException {
		String zeile = reader.readLine();
		if (zeile != null) {
			return zeile.split(";");
		}
		return null;
	}

	@Override
	public void schliesseDatei() throws IOException {
		reader.close();
	}
}
