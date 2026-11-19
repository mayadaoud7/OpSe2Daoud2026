package fileCreatorsDaoud;

import java.io.IOException;

public class ConcreteCreatorAB extends ReaderCreatorDaoud {

	@Override
	public ReaderProductDaoud factoryMethod(String typ) throws IOException {
		if ("csv".equals(typ)) {
			return new ReaderProductA();
		} else {
			return new ReaderProductB();
		}
	}

}
