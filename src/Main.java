import java.util.*;
public class Main {
    public static void main(String[] args) {
//    purmulation("","abc");
//    ArrayList<String> ans=purmArr("","abc");
//        System.out.println(ans);
//        System.out.println(countPurm("","ABC"));
//        List<String>list=pad("","12");
//        System.out.println(list);
        dice("",4);
        ArrayList<String>list= diceArr("",4);
        System.out.println(list);

    }
    static void purmulation(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return ;
        }
        char ch = up.charAt(0);
        for (int i = 0; i<=p.length(); i++) {
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            purmulation(f+ch+s,up.substring(1));
        }
    }
    static ArrayList<String> purmArr(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> ans=new ArrayList<>();

        for (int i = 0; i <=p.length() ; i++) {
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            ans.addAll(purmArr(f+ch+s,up.substring(1)));
        }
        return ans;
    }
    static int countPurm(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int  count=0;
        char ch=up.charAt(0);
        for (int i = 0; i <=p.length(); i++) {
            String f=p.substring(0,i);
            String s=p.substring(i,p.length());
            count=count+countPurm(f+ch+s,up.substring(1));
        }
        return  count;
    }



    static ArrayList<String> pad1(String p,String up){
        if(up.isEmpty()){
            ArrayList<String>list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list1=new ArrayList<>();
        int digit=up.charAt(0)-'0';
        for(int i=(digit-1)*3;i<digit*3;i++){
            char ch=(char)('a'+i);
            list1.addAll(pad(ch+p,up.substring(1)));
        }
        return list1;
    }
// Online Java Compiler
// Use this editor to write, compile and run your Java code online

    static String[]m={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static  List<String> pad(String p,String up){
        if(up.isEmpty()){
            List<String>list=new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String>l1=new ArrayList<>();
        int d=up.charAt(0)-'0';
        if(d==1||d==0)return pad(p,up.substring(1));
        String let=m[d];
        for(int i=0;i<let.length();i++){
            char ch=let.charAt(i);
            l1.addAll(pad(p+ch,up.substring(1)));
        }
        return l1;
    }

    static void dice(String p,int target ){
        if(target==0){
            System.out.println(p);
            return ;
        }
        for (int i = 1; i <=6&&i<=target; i++) {
            dice(p+i,target-i);
        }
    }
    static ArrayList<String> diceArr(String p,int target){
        if(target==0){
            ArrayList<String>list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> lis=new ArrayList<>();
        for (int i = 1; i <=6&&i<=target ; i++) {
            lis.addAll(diceArr(p+i,target-i));
        }
        return lis;
    }
}
