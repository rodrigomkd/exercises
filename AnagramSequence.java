import java.util.*;

public class AnagramSequence {
    
    public static int isAnagram(String string, String valid) {
        Map<Character, Integer> characters = new HashMap<>();
        
        int index = 1;
        int position = 0;
        boolean isAnagram = false;
        boolean isForValid = false;
        for(int i=0;i<string.toCharArray().length;i++) {
            char ch = string.charAt(i);
            
            if(isForValid) {
                char validChar = valid.charAt(index - 1);
                if(characters.containsKey(validChar)) {
                    int repeat = characters.get(validChar);
                    if(repeat == 1) {
                        characters.remove(validChar);
                    } else {
                        repeat--;
                        characters.put(ch, repeat);
                    }
                }
                
                if(index == valid.length()) {
                    isAnagram = characters.isEmpty();
                    if(isAnagram) {
                        break;
                    } else {
                        characters.clear();
                        isForValid = false;
                        index = 0;
                        position++;
                        i = position - 1;
                    }
                }
                
                index++;
                continue;
            }
            
            int count = characters.containsKey(ch) ? characters.get(ch) : 1;
            characters.put(ch, count);
            
            if(index == valid.length()) {
                i = position - 1; 
                index = 0;
                isForValid = true;
            }
            
            index++;
        }
        
        return isAnagram ? position : -1;
    }
    
    public static void main(String args[]) {
      System.out.println(isAnagram("welcome to git", "g o"));
      System.out.println(isAnagram("hello world!", "lol"));
      System.out.println(isAnagram("java programming", "por"));
    }
}
