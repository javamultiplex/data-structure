package com.javamultiplex.datastructure.disjointset;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


/**
 * 
 * @author Rohit Agarwal
 * @Initialization - O(N)
 * @Find - O(1)
 * @Union - O(N)
 * If M union-find operations and N objects then it will take MN time.
 */
public class QuickFindUF {

	private int[] id;
	
	public QuickFindUF(int n){
		id=new int[n];
		for(int i=0;i<n;i++){
			id[i]=i;
		}
	}
	
	public boolean isConnected(int p,int q){
		return id[p]==id[q];
	}
	
	public void union(int p,int q){
		int pid=id[p];
		int qid=id[q];
		int n=id.length;
		for(int i=0;i<n;i++){
			if(id[i]==pid){
				id[i]=qid;
			}
		}
	}
	
	public int count(){
		int n=id.length;
		Map<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<n;i++){
			if(map.containsKey(id[i])){
				map.put(id[i],map.get(id[i])+1);
			}else{
				map.put(id[i], 1);
			}
		}
		
		Set<Entry<Integer,Integer>> set=map.entrySet();
		List<Entry<Integer,Integer>> list=new ArrayList<>(set);
		Comparator<Entry<Integer,Integer>> comp=new Comparator<Map.Entry<Integer,Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				
				if(o1.getValue()>o2.getValue()){
					return -1;
				}else if(o1.getValue()<o2.getValue()){
					return 1;
				}else{
					return 0;
				}
				
			}
		};
		
		Collections.sort(list,comp);
		return list.get(0).getValue();
	}
	
	
}
