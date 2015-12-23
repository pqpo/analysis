package chapter12;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;

public class VolatileTest {
	boolean isExit;
	
	public void tryExit(){
		if(isExit == !isExit)
			System.exit(0);
	}
	
	public void swapValue(){
		isExit = !isExit;
	}
	
	public static void main(String[] args) throws IOException{
		FileInputStream fis = new FileInputStream(new File("D:/MediaInfo/mediainfo.txt"));
		FileChannel channel = fis.getChannel();
		MappedByteBuffer byteBuffer = channel.map(MapMode.READ_ONLY, 0, channel.size());
		byte[] bytes = new byte[(int) channel.size()];
		byteBuffer.get(bytes);
		System.out.println(new String(bytes,"gbk"));
		channel.close();
		fis.close();
	}

}
