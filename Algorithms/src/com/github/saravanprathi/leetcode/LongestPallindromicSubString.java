package com.github.saravanprathi.leetcode;

class Solution {
        private int max_so_far=1;
	    private int max_start=0;
	    public String longestPalindrome(String s) {
	        if(s.length()==0)
	            return "";
	        char a[]=s.toCharArray();
	        for(int i=0;i<=s.length()-2;i++){
	        longestPalindrome(a,i,i);
	        longestPalindrome(a,i,i+1);
	        }
	        return s.substring(max_start, max_start+max_so_far);
	    }
	    
	    public void longestPalindrome(char[] s,int start, int end){
	        while( s[start]==s[end]){
            if(end-start+1>max_so_far) {
                max_so_far=end-start+1;
                max_start=start;
            }
            	
            if(!(start-1>=0 && end+2<=s.length)) {
            	break;
            }
                start--;
            	end++;
            }
	    }
}