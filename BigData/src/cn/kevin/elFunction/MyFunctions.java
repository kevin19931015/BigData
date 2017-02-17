package cn.kevin.elFunction;

public class MyFunctions {
	public static boolean contains(String[] strs,String s){
		boolean result = false;
		if(strs!=null&&strs.length>0){
			for(int i=0;i<strs.length;i++){
				if(strs[i].equals(s)){
					result = true;
					break;
				}
			}
		}
		return result;
	}
}
