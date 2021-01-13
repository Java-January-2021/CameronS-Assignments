public class StringManipulator {
    public String trimAndConcat(String str1,String str2){
        return((str1.trim()).concat(str2.trim()));
    }
    public Integer getIndexOrNull(String str,char letter){
        Integer i = str.indexOf(letter);
        if (i == -1) {
            return null;
        }
        return(i);
    }
    public Integer getIndexOrNull(String word,String str){
        Integer i = word.indexOf(str);
        if(i == -1) {
            return null;
        }
        return(i);
    }
    public String concatSubstring(String str1, int var1, int var2, String str2){
        return(str1.substring(var1,var2).concat(str2));
    }
}