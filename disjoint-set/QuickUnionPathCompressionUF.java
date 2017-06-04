package union_find;

import java.util.Arrays;


/**
 * If M union-find operations and N objects then it will take N+MlogN time.
 */
public class QuickUnionPathCompressionUF {

	private int[] id;
	
	public QuickUnionPathCompressionUF(int n){
		id=new int[n];
		for(int i=0;i<n;i++){
			id[i]=i;
		}
	}
	
	private int root(int i){
		while(i!=id[i]){
			id[i]=id[id[i]];  //Path Compression
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
		id[i]=id[j];
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
