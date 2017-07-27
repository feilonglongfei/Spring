package com.login.test.demo;

import java.util.ArrayList;
import java.util.Arrays;

public class Demo30 {
	
	public void getNewArray(ArrayList<Integer> listOri){
		
		ArrayList<Integer> tempList = new ArrayList<Integer>();
		if(listOri.size() > 1){
			for (Integer integer : listOri) {
				tempList.add(new Integer(integer));
			}
		}
		
		for(int i=0; i<listOri.size(); i++){
			System.out.print(listOri.get(i));
			tempList.remove(i);
			if(!tempList.isEmpty()){
				getNewArray(tempList);
			} else {
				System.out.println();
			}
		}
		
	}

	public static void main(String[] args) {
		
		int[] ints = {1, 2, 3};
		
		int[] intsColl = new int[3];

		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		
		System.out.println(Arrays.toString(ints));
		
		Demo30 demo30 = new Demo30();
		ArrayList<Integer> arrayNew = new ArrayList<Integer>();
		demo30.getNewArray(arrayList);
		
//		for(int i=0; i<ints.length; i++){
//			for(int j=0; j<ints.length; j++){
//				for(int k=0; k<ints.length; k++){
//					if(i!=j && j!=k && k!=i){
//						System.out.println(arrayList.get(i).toString().concat(arrayList.get(j).toString()).concat(arrayList.get(k).toString()));
//					}
//				}
//			}
//		}
		
	}
}
