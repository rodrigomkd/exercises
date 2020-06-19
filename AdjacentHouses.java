// Example 1:

// Input: [2,3,2]


//   3
// 2   2
// Output: 3
// Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
//               because they are adjacent houses.

// Example 2:

// Input: [1,2,3,1]
    
//   2
// 1   3
//   1
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
//              Total amount you can rob = 1 + 3 = 4.

import java.io.*;
import java.util.*;

class MyCode {
  
  //Complexity: O(n2)
  public static int getMaxRobHouses(int [] arr) {
    int middle = arr.length / 2;
    
    List<Set<Integer>> values = new ArrayList<>();
    
    int left = middle - 1;
    int rigth = middle + 1;
    
    //add the middle
    Set<Integer> set = new HashSet<>();
    set.add(middle);
    values.add(set);
    
    //generate matrix to determine the adjacent
    while(left >= 0 || rigth < arr.length) {
      set = new HashSet<>();
      if(left >= 0) {
        set.add(left);
      }
      
      if(rigth < arr.length) {
        set.add(rigth);
      }
      
      values.add(set);
      left--;
      rigth++;
    }
    
    //start with 0
    int max = 0;
    int tempMax = 0;
    Set<Integer> positions = new HashSet<>();
    for(int i=0;i<values.size();i++) {
      if(i == 1) {
        continue;
      }
      set = values.get(i);
      
      //get max value
      int maxValue = 0;
      int tempPosition = 0;
      for(int position : set) {
        
        //check neighbors
        if(positions.contains(position - 1) || positions.contains(position + 1)) {
          continue;
        }
        
        if(arr[position] > maxValue) {
          maxValue = arr[position];
          tempPosition = position;
        }
      }
      
      positions.add(tempPosition);
      tempMax += maxValue;
    }
    
    //start with 1
    max = tempMax;
    tempMax = 0;   
    positions = new HashSet<>();
    for(int i=1;i<values.size();i++) {
      set = values.get(i);
      
      //get max value
      int maxValue = 0;
      int tempPosition = 0;
      for(int position : set) {
        
        //check neighbors
        if(positions.contains(position - 1) || positions.contains(position + 1)) {
          continue;
        }
        
        if(arr[position] > maxValue) {        
          maxValue = arr[position];
          tempPosition = position;        
        }     
        
      }
      
      positions.add(tempPosition);
      tempMax += maxValue;
    }
    
    return tempMax > max ? tempMax : max;
  }
  
	public static void main (String[] args) {
    int [] arr1 = {2,3,2}; //3
    int [] arr2 = {1,2,3,1}; //4
    int [] arr3 = {6, 7, 1, 3, 8, 2, 4}; // 19
    int [] arr4 = {5, 3, 4, 11, 2}; // 16
    
		System.out.println(getMaxRobHouses(arr1));
    System.out.println(getMaxRobHouses(arr2));
    System.out.println(getMaxRobHouses(arr3));
    System.out.println(getMaxRobHouses(arr4));
	}
}
