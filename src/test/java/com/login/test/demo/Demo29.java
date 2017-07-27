/**
 * 
 */
package com.login.test.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;

/**
 * @author Administrator
 *
 */
public class Demo29 {

	
	public int[] buddleSort(int[] ints) {
		int temp;
		for (int i = ints.length-1; i>0 ; i--) {
			for (int j = 0; j < i; j++) {
				if(ints[j] > ints[j+1]){
					temp = ints[j];
					ints[j] = ints[j+1];
					ints[j+1] = temp;
				}
			}
		}
		return ints;
	}
	
	public int[] quickSort(int[] ints, int low, int hight) {
		
		int i=low, j=hight;
		int temp;
		
		while(i < j){
			while(i<j && ints[i] < ints[j]) j--;
			if(i < j){
				temp = ints[j];
				ints[j] = ints[i];
				ints[i] = temp;
				j--;
			}
			while(i<j && ints[i] < ints[j]) i++;
			if(i < j){
				temp = ints[j];
				ints[j] = ints[i];
				ints[i] = temp;
				i++;
			}
		}
		
		if(i > low) quickSort(ints, low, i-1);
		if(j < hight) quickSort(ints, j+1, hight);
		
		return ints;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		RandomUtils randomUtils = new RandomUtils();
		int[] ints = new int[10];		
//		int[] ints = {10, 85, 59, 93, 49, 39, 39, 48, 17, 65};

		for (int i = 0; i < ints.length; i++) {
			ints[i] = randomUtils.nextInt(100);
		}
		System.out.println(Arrays.toString(ints));
		
		Demo29 demo29 = new Demo29();
//		ints = demo29.buddleSort(ints);
		ints = demo29.quickSort(ints, 0, ints.length -1);
		System.out.println(Arrays.toString(ints));
	}

}
