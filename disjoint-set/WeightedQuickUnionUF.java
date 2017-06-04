package com.javamultiplex.datastructure.disjointset;

import java.util.Arrays;


/**
 * 
 * @author Rohit Agarwal
 * @Initialization - O(N)
 * @Find - O(logN)
 * @Union - O(logN)
 * If M union-find operations and N objects then it will take N+MlogN time.
 */
public class WeightedQuickUnionUF {

	private int[] id;
	private int[] sz;
	
	public WeightedQuickUnionUF(int n){
		id=new int[n];
		for(int i=0;i<n;i++){
			id[i]=i;
		}
		sz=new int[n];
		Arrays.fill(sz, 1);
	}
	
	private int root(int i){
		while(i!=id[i]){
			i=id[i];
		}
		return i;
	}
	
	public boolean isConnected(int p,int q){
		return root(p)==root(q);
	}
	
	public void union(int p,int q){
		int i=root(p);
		int j=root(q);
		if(sz[i]<sz[j]){
			id[i]=j;
			sz[j]+=sz[i];
		}else{
			id[j]=i;
			sz[i]+=sz[j];
		}
	}
	
	public int count()
	{
		int n=id.length;
		int[] count=new int[n];
		Arrays.fill(count, 0);
		for(int i=0;i<n;i++){
			count[root(id[i])]++;
		}
		Arrays.sort(count);
		return count[n-1];
	}
	
	
}
