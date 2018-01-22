package com.teacher.util ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatJudgeUtil {

    public static boolean isEmail(String email){
        String check = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
//		String check = "^[a-zA-Z0-9]+@[a-zA-Z0-9-_]+\\.[a-zA-Z0-9]{2,3}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(email);
        return matcher.find();
    }

    public static boolean isMobile(String mobile){
        //String check = "^（（13[0-9]）|（15[^4,\\D]）|（18[0,5-9]））\\d{8}$";
        String check = "^1[3|4|5|8|7]\\d{9}$";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(mobile);
        return matcher.find();
    }

    public static boolean inValidUserName(String userName){
        String check = "[\\^*<>%&',;=?$\"':#!~\\]\\[{}\\\\/`\\|\\+]";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(userName);
        return matcher.find();
    }

    public static boolean inValidPath(String path){
        String check="[\\\\:*?\"<>|]";
        Pattern regex = Pattern.compile(check);
        Matcher matcher = regex.matcher(path);
        return matcher.find();
    }
    public static void main(String[] args) {
        String b = "ty_@126.-com.cn";
        boolean a = isEmail(b);
        System.err.println(b);
        System.err.println(a);
    }

}
