package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Utilities.TestD;

public class main {

	public static void main(String[] args) {
		int [][] arrayA = { { 4,5,6,12,4}, {9,3,1,6}, {2,7,8,8} };
		aMethod(arrayA);
		System.out.println(arrayA[1].length/2);
		System.out.println(arrayA[0].length);
		System.out.println(arrayA[0][1]==01);
		System.out.println(arrayA[2][3]);
		System.out.println(arrayA[1][2]);
		
	}
	
	public static void aMethod(int[][] a) {
		a[1][1] = 7; a[0][1] = 7;
		for(int i=0; i<=2; i++) {
			a[i][i+1] = 2*i-i+1;
		}
	}
}