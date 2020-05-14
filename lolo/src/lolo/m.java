package lolo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class m {

	public m() {
		
	}
	public void lire() {
		File f=new File("C:/Users/pc/Desktop/test1.txt");
		BufferedReader br=null;
		try {
			FileReader fr= new FileReader(f);
			br= new BufferedReader(fr);
			String z;
			z=br.readLine();
			System.out.println(z);
			
		}
		catch(FileNotFoundException e) {
			System.out.println("impossible");
		}
		catch(IOException e) {
			e.printStackTrace(); 
		}
		try {
			br.close();
		} catch(IOException e) {
			System.out.println("impossible");
		}
		catch(NullPointerException e) {
			System.out.println("morida");
		}
	}
	
	public void ecrire() throws IOException {
	File f=new File("C:/Users/pc/Desktop/test1.txt");
	Set <Integer > s=new HashSet<>();
	for(int i=0;i<5;i++) {
		s.add(i);
	}
	try(BufferedWriter bw= new BufferedWriter(new FileWriter(f))) {
		
	
	String z;
	for (int a: s) {
		z=a+"";
		bw.write(z);
	}
	}
	catch(FileNotFoundException e) {
		System.out.println("impossible");
	}
	catch(IOException e) {
		e.printStackTrace(); 
	}

	
	
}
}
