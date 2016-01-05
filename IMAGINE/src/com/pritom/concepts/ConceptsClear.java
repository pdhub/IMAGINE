package com.pritom.concepts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class ConceptsClear {

	public static void main(String[] args) {
		System.out.println(checkFinally());
		
		try {
			checkSerial();
		} catch (Exception e) {
			
		}
		
		checkStringRef();
		
		checkSet();
		
		try {
			checkNullInHashMapAndHashTable();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		checkQueue();
		
		checkReplace();

	}
	
	private static void checkReplace() {
		System.out.println("checkReplace");
		String s = "abc";
		char[] c = s.toCharArray();
		c[1]='z';
		String newString = "";
		for (int i = 0; i < c.length; i++) {
			newString+=c[i];
		}
		
		System.out.println(newString);
		
	}

	private static void checkQueue() {
		Queue queue = new LinkedList();
		queue.add(5);
		queue.add(6);
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		
	}

	private static void checkNullInHashMapAndHashTable() {
		Map map = new HashMap();
		map.put(null, 1);
		map.put(null, 2);
		map.put(1, "One");
		map.put(2, "two");
		Collection s = map.values();
		System.out.println(s.size());
		
		Hashtable table = new Hashtable();
		table.put(null, 1);
		
	}

	private static void checkSet() {
		Set set = new HashSet();
		set.add(new String("1"));
		set.add(new String("1"));
		set.add(new String("1"));
		System.out.println(set.size());
		set.add(new BNotSerial());
		set.add(new BNotSerial());
		set.add(new BNotSerial());
		System.out.println(set.size());
		
	}

	private static void checkStringRef() {
		String a = "abc";
		String b=a;
		a=a+"d";
		b=b+"c";
		System.out.println(a+" : "+b);
		a.concat("C1");
		System.out.println(a);
		
	}

	private static void checkSerial() {
		ASerial a = new ASerial();
		a.aval=5;
		try {
			FileOutputStream fs = new FileOutputStream("SerailFile.txt");
			ObjectOutputStream obj = new ObjectOutputStream(fs);
			obj.writeObject(a);
			obj.close();
			FileInputStream fin = new FileInputStream("SerailFile.txt");
			ObjectInputStream obj2 = new ObjectInputStream(fin);
			 a = (ASerial) obj2.readObject();
			 System.out.println(a.aval+" "+a.b.bval);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}


	private static int checkFinally() {
		try{
			int x = 1/0;
			return -1;
		}catch(Exception e){
			System.out.println("in exception");
			return 0;
		}finally{
			return 1;
		}
	}

}

class ASerial extends BNotSerial implements Serializable{
	public BNotSerial b;
	public int aval = 0;
	ASerial() {
		System.out.println("A const");
		b=new BNotSerial();
		//aval=1;
	}
	
	
}
class BNotSerial{
	public int bval = 0;
	BNotSerial(){
		System.out.println("B consr");
		bval=1;
	}
	
}
