package fileCreatorsDaoud;

import java.io.IOException;

public abstract class ReaderCreatorDaoud {

	public abstract ReaderProductDaoud factoryMethod(String typ) throws IOException;

}
