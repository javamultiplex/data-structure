package union_find;

import java.util.Arrays;


/**
 * 
 * @author Rohit Agarwal
 * @Initialization - O(N)
 * @Find - O(N)
 * @Union - O(N)
 * If M union-find operations and N objects then it will take MN time.
 */
public class QuickUnionUF {

	private int[] id;
	
	public QuickUnionUF(int n){
		id=new int[n];
		for(int i=0;i<n;i++){
			id[i]=i;
		}
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
