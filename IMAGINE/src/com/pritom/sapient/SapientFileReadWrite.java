package com.pritom.sapient;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * Read and write to a file
 * */
public class SapientFileReadWrite {

	public static void main(String[] args) throws IOException {
		FileReader fs = new FileReader("C:/Softwares/eclipse/IMAGINE_JBOSS.log");
		BufferedReader bf = new BufferedReader(fs);
		String data = "";
		while ((data = bf.readLine()) != null) {
			System.out.println(data);
			// bos.write(data);
		}
		
		/*If you need to write use a File Writer*/

	}

}
