package hearth.Code.Monk.Revision;

import java.util.Scanner;

public class IllegibleString {

	public static void minMax(String s){
		
		String smax,smin;
		smax=s;
		smin=s;
		smax=smax.replaceAll("w","vv");
		smin=smax.replaceAll("vv","w");	
		
		System.out.println(smin.length()+" "+smax.length());
		
		//Create a new String, add 2 v's everytime you read a w
		//Now read the newly created string again, if you get two v's increase the count. lenght - count is the minimum
	}
	
	public static void minMaxAgain(String s){
		String n = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c=='w')
				n+="vv";
			else
				n+="w";
		}
		int max = n.length();
		
		int vc0unt=0;
		 /*for(int i=0;i+1<n.length();++i)
	     {
	     	if(E[i]=='v'&&E[i+1]=='v')
	     	   {
	     	   	++vn;
	     	   	++i;
	     	   }
	     } */
		
		/*string s;
    int n;
    cin >> n;
    vector <char> v;
    cin >> s;
    int i,c = 0, d = 0;
    for (i = 0; i < n; i++) {
    	if (s[i] == 'w') {
    		v.push_back('v');
    		v.push_back('v');
    	}
    	else {
    		v.push_back(s[i]);
    	}
    }
    for (i = 0; i < v.size(); i++) {
    	while (v[i] == 'v') {
    		c++;
    		i++;
    	}
    	d = d + c/2;
    	c = 0;
    }
    cout << v.size()-d <<" "<<v.size() << endl;
		*/
		int min = n.length()-vc0unt;
		System.out.println(min+" "+max);
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int len = Integer.parseInt(in.nextLine());
		String str = in.nextLine();
			minMax(str);
			minMaxAgain(str);
		
	}

}
