class Solution {
    public int maximum69Number (int num) {
        String st=String.valueOf(num);
        StringBuilder sb=new StringBuilder(st);
        int i=0;
        while(i<st.length()&&st.charAt(i)=='9')
            i++;
        
        if(i<st.length())
            sb.setCharAt(i,'9');
        return Integer.valueOf(sb.toString());
    }
}