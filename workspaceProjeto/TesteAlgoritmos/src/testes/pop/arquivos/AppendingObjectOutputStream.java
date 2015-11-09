package testes.pop.arquivos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AppendingObjectOutputStream extends ObjectOutputStream{
	
	public AppendingObjectOutputStream(OutputStream outputStream) throws IOException {
		super(outputStream);
	}
	
	@Override
	public void writeStreamHeader() throws IOException {
		reset();
	}

}
