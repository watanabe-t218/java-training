package ex02;

import java.lang.ref.WeakReference;
import java.io.File;

class DataHandler {

	private WeakReference<File> lastFile;
	private WeakReference<byte[]> lastData;	
	byte[] readFile(File file) {
		byte[] data;
		if (file == null)
			throw new NullPointerException("file must not be null");
		

		if(file.equals(lastFile.get())) {
			data = lastData.get();
			if(data != null) 
				return data;
		}
			
		data = readBytesFromFile(file);
		lastFile = new WeakReference<File>(file);
		lastData = new WeakReference<byte[]>(data);
		return data;
	}

	private byte[] readBytesFromFile(File file) {
		return null;
	} 
}