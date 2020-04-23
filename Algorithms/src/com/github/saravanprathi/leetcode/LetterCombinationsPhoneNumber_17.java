package com.github.saravanprathi.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber_17 {
	private String KEYS[]={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {     
        List<String> ret=new ArrayList();
        if(digits.equals(""))
            return ret;
        helper("",digits,0,ret);
        return ret;
    }
    public void helper(String prefix,String digits,int offset,List<String> ret){
        if(offset==digits.length()){
            ret.add(prefix);
            return;
        }
        String temp=KEYS[digits.charAt(offset)-'0'];
        for(int i=0;i<temp.length();i++){
            helper(prefix+temp.charAt(i),digits,offset+1,ret);
        }
    }
}
