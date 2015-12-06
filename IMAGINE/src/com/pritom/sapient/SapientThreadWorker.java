package com.pritom.sapient;

import java.util.List;
import java.util.concurrent.Callable;

public class SapientThreadWorker implements Callable<Integer>{

	public List<Integer> listInt;
	public SapientThreadWorker(List listInt){
		this.listInt = listInt;
	}
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for (int i = 0; i < listInt.size(); i++) {
			sum+=listInt.get(0);
			
		}
		return sum;
	}
	
}
