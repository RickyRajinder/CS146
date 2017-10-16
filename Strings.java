
public class Strings {

    public static String uniqueLetters(String str){
        String unique = "";
        String target = "";
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            target = str.substring(i, i+1);
            for (int j = 0; j < str.length(); j++){
                if (target.equals(str.substring(j, j+1))){
                    count++;
                }
            }
            if (count <= 1){
                unique = unique.concat(target);
            }
                count = 0;
            }
        return unique;
    }

    public static void main (String[] args){
        String str = "Mississippi";
        System.out.println(uniqueLetters(str));
    }

}
