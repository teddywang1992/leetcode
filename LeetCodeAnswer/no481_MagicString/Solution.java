package no481_MagicString;

public class Solution {
    public int magicalString(int n) {
        StringBuilder magic = new StringBuilder("122");
        int pt1 = 2, pt2 = magic.length(), count = 0; //initiate pointers
        //generate sequence directly
        while(magic.length() < n){
            if(magic.charAt(pt1) == '1'){
                if(magic.charAt(pt2-1) == '1') magic.append(2);
                else magic.append(1);
                pt2++;
            }else{ //==2
                if(magic.charAt(pt2-1) == '1') magic.append(22);
                else magic.append(11);
                pt2+=2;
            }
            pt1++;
        }
        for(int i=0;i < n;i++) {
            if (magic.charAt(i) == '1') count++;
        }
        return count;
    }
}