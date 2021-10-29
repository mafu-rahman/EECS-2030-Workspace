package model;

import java.util.ArrayList;

public class functions {
	
	public int[] twoSum(int[] nums, int target) {
        int[] a = new int[nums.length];
        int c = 0;
        for(int i=0; i<nums.length; i++){
            int remain = target - nums[i];
            for(int j=0; j<nums.length; j++){
                if(nums[j] == remain){
                    a[c] = i;
                    c++;
                    a[c] = j;	            
                }
            }
        }
       return a;
    }

}
