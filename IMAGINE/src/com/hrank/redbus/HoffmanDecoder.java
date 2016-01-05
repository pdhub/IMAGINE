package com.hrank.redbus;


public class HoffmanDecoder {

	String encodedText = new String("1010");
	
	public static void main(String[] args) {
		
		String[] encodings = {"01	a", "110	b"};
		String encodedstring = "01110";
		
		System.out.println(Decoding(encodings, encodedstring));
	}
    public static String Decoding(String[] encodings, String encodedstring)
    {
    	StringBuffer decodedstring=new StringBuffer();
    	java.util.HashMap dict = new java.util.HashMap();
    	
		int min =Integer.MAX_VALUE, max=Integer.MIN_VALUE;
		
		
    	for (int i = 0; i < encodings.length; i++) {
			String[] tmp = encodings[i].split("\t");
			dict.put(tmp[0],tmp[1]);
		}
    	
    	java.util.Iterator itr = dict.keySet().iterator();
		while(itr.hasNext())
		{
			int tmp = String.valueOf(itr.next()).length();
			if(min>tmp)
				min = tmp;
			if(max<tmp)
				max= tmp;
		}
		
		int startPos =0 , endPos=min;
		while(endPos<=encodedstring.length())
		{
			String chunck = encodedstring.substring(startPos, endPos);
			if(dict.containsKey((chunck))){
				
				decodedstring.append(dict.get(chunck));
				startPos = endPos;
				endPos = endPos+min;
				
			}else
				endPos++;
				
		}
		
		return decodedstring.toString();
    }
	
}
