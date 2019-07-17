public class HackerRank {
  
  static List<String> getPermutation(String s, int position) {
        List<String> permutations = new ArrayList<String>();
        int i = position + 1;
        while(i <= s.length()) {
            permutations.add(s.substring(position, i));
            //System.out.println(s.substring(position, i));
            i++;
        }
        
        return permutations;
    }

    static List<String> getAllPermutations(String s) {
        List<String> permutations = new ArrayList<String>();
        for(int i=0;i<s.length();i++) {
            permutations.addAll(getPermutation(s, i));
        }

        return permutations;
    }

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        //generate pairs
        int count = 0;
        List<String> permutations = getAllPermutations(s);
        //System.out.println("permutations: " + permutations);
        for(int i=0;i<permutations.size();i++) {
            for(int j=i+1;j<permutations.size();j++) {
               // System.out.println("entra " + j + " : " + s.length());
                if(j == permutations.size()) {
                 //   System.out.println("entra");
                    break;
                }
                //System.out.println("i: " + permutations.get(i) + " J: " + permutations.get(j));
                if(isAnagram(permutations.get(i), permutations.get(j))) {
                    count++;
                }
            }
        }
        
        return count;
    }

    static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        
        for(char ch : s1.toCharArray()) {
            if(map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch) + 1);
            } else {
                map1.put(ch, 1);
            }
        }
        
        for(char ch : s2.toCharArray()) {
            if(map2.containsKey(ch)) {
                map2.put(ch, map2.get(ch) + 1);
            } else {
                map2.put(ch, 1);
            }
        }
        
        for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
		    if(! entry.getValue().equals(map2.get(entry.getKey()))) {
		        return false;
		    }
	    }
	    
	    return true;
    }
    
  public static void main(String [] mkd) {
  
  }
}
