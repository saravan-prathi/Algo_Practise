package com.github.saravanprathi.leetcode;

class ZigZag {
    public String convert(String s, int numRows) {
        StringBuffer[] sb=new StringBuffer[numRows];
        for(int i=0;i<numRows;i++)
        	sb[i]=new StringBuffer();
        int i=0;
        int n=s.length();
        while(i<n) {
        	for(int j=0;j<numRows && i<n;j++)
        		sb[j].append(s.charAt(i++));
        	
        	for(int k=numRows-2;k>=1 && i<n;k--)
        		sb[k].append(s.charAt(i++));
        }
        
        for(int j=1;j<numRows;j++)
        	sb[0].append(sb[j]);
        return sb[0].toString();
    }
}
