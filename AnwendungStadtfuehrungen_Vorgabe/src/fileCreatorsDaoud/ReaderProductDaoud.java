package fileCreatorsDaoud;

import java.io.IOException;

public abstract class ReaderProductDaoud {

	public abstract String[] leseAusDatei() throws IOException;

	public abstract void schliesseDatei() throws IOException;

}
