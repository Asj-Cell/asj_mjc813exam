package com.mjc813;

public class MjcValidCheck {

    public boolean isValidPhoneNumber(String number) {
        if (number == null ) {
            return false;
        }
        String[] splitNumber = number.split("-");

        if (splitNumber.length != 3) {
            return false;
        }

        if (splitNumber[0].length() != 3 || splitNumber[1].length() != 4 || splitNumber[2].length() != 4) {
            return false;
        }


        String numberWithoutHyphen = number.replace("-", "");
        if (! isNumberic(numberWithoutHyphen.toCharArray())) {
            return false;
        }

        return true;
    }

    private boolean isNumberic(char[] numCharArray) {
        for (char c : numCharArray) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }


    public boolean isValidZipNumber(String text) {
        if (text == null || text.length() != 5 || text.contains("0")) {
            return false;
        }
        if (!isNumberic(text.toCharArray())) {
            return false;
        }
        return true;
    }
//     => text 문자열이 이메일주소(~~~@***.com, ~~~@***.***.net 등등)를 유효하게 갖고 있는 문자열인지 검증해서 맞으면 true를 리턴한다.
    public boolean isValidEmail(String text) {
        if (text == null) {
            return false;
        }

        int atIndex = text.indexOf("@");
        int dotIndex = text.indexOf(".");
        if (atIndex == -1 || dotIndex == -1) {
            return false;
        }

        if (atIndex != text.lastIndexOf("@")) {
            return false;
        }


        String substring = text.substring(dotIndex+1);
        if (substring.length() != 3) {
            return false;
        }

        return true;
    }
}
