//{ Driver Code Starts
import java.util.*;
class Disjoint{
	public static void main(String[] args){
		Scanner sc=new Scanner (System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n+1];
			for(int i=1;i<=n;i++)
				a[i]=i;
			int k=sc.nextInt();
			GfG g=new GfG();
			for(int i=0;i<k;i++){
				String s=sc.next();
				if(s.equals("UNION")){
					int x=sc.nextInt();
					int z=sc.nextInt();
					g.unionSet(a,x,z);
				}
				else{
					int x=sc.nextInt();
					int parent=g.find(a,x);
					System.out.print(parent+" ");
				}
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG
{
    int size[]=new int[100001];
    
	int find(int parent[],int X)//find Parent
    {
          //add code here.
          if(parent[X]==X)
          return X;
          return parent[X]=find(parent,parent[X]);
          
	}
	void unionSet(int parent[],int X,int Z)
        {
         //add code here.
         int ulx=find(parent,X);  //ultimate parent of x
         int ulz=find(parent,Z);   //ultimate parent of z
         if(ulx==ulz)
         return;     //they already belong to the same component
         if(size[ulx]<=size[ulz])
         {
             parent[ulx]=ulz;
             size[ulz]+=size[ulx];//larger becomes the parent
         }
         else
         if(size[ulz]<size[ulx])
         {
         parent[ulz]=ulx;
         size[ulx]+=size[ulz];
         }

	}
}
