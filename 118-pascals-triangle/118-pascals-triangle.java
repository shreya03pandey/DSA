class Solution {
    public List<List<Integer>> generate(int numRows) {
      List<List<Integer>> res=new ArrayList<List<Integer>>();
        ArrayList<Integer>prev=null;
        for(int i=0;i<numRows;i++)
        {
          ArrayList<Integer>al=new ArrayList<Integer>();
            for(int j=0;j<=i;j++)
            {
                if(j==0||j==i)
                    al.add(1);
                else
                    al.add(prev.get(j-1)+prev.get(j));
            }
            res.add(al);
            prev=al;
        }
        return res;
    }
}