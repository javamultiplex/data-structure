package com.javamultiplex.datastructure.recursion;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class StringPermutations {

	
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		System.out.println("Enter String : ");
		String string=input.next();
		Map<Character,Integer> map=getMapByString(string);
		char[] ch=new char[map.size()];
		int[] count=new int[map.size()];
		int i=0;
		for(Entry<Character,Integer> entry:map.entrySet()){
			
			ch[i]=entry.getKey();
			count[i]=entry.getValue();
			i++;
		}
		char[] result=new char[string.length()];
		permute(ch,count,result,0);
		
		input.close();
	
	}

	private static void permute(char[] ch, int[] count, char[] result, int level) {
		
		if(level==result.length){
			System.out.println(new String(result));
		}else
		{
			for(int i=0;i<count.length;i++){
				
				if(count[i]==0){
					continue;
				}else{
					count[i]--;
					result[level]=ch[i];
					permute(ch, count, result, level+1);
					count[i]++;
				}
				
			}
		}
		
	}


	private static Map<Character, Integer> getMapByString(String string) {
		
		Map<Character,Integer> map=new TreeMap<>();
		int length=string.length();
		char ch='\u0000';
		int value=0;
		for(int i=0;i<length;i++){
			
			ch=string.charAt(i);
			if(map.containsKey(ch)){
				value=map.get(ch);
				map.put(ch,++value);
			}else{
				map.put(ch, 1);
			}
			
		}
		
		return map;
	}
	
	
}
