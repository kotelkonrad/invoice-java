package models;

public class SplitData {
    public static class Result {
        public String str1, str2, str3, str5;
        public double val1, val2, val3, val4;

        public Result(String str1, String str2, String str3, double val1, double val2, String str5, double val3, double val4) {
            this.str1 = str1;
            this.str2 = str2;
            this.str3 = str3;
            this.val1 = val1;
            this.val2 = val2;
            this.str5 = str5;
            this.val3 = val3;
            this.val4 = val4;
        }
    }

    public static Result split(String[] split) {
        //Nazwa tow. lub usłu.
        String str1 = split[0].trim().replace("_", " ");
        //Jedno. miary
        String str2 = split[1].trim().replace("_", " ");
        //Ilosc
        String str3 = split[2].trim();
        //Cena jednost. bez VAT
        double val1 = Double.parseDouble(split[3].trim());
        //Wartość sprze. bez VAT
        double val2 = val1 * Double.parseDouble(str3);
        //Procent podatku VAT
        String str5 = split[4].trim() + "%";
        //Kwota pod. VAT
        double val3 = val2 * (Double.parseDouble(split[4].trim())/100.0);
        //Wartość sprze. z VAT
        double val4 = val2 + val3;

        return new Result(str1, str2, str3, val1, val2, str5, val3, val4);
    }
}