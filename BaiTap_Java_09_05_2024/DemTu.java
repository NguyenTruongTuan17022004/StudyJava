package BaiTap_Java_09_05_2024;

import java.util.HashMap;
import java.util.Map;

public class DemTu {
    public static void main(String[] args) {
        String NhapChuoi = "hello hi my hi hello";

        String[] chuoi = NhapChuoi.split("\\s");

        Map<String, Integer> Dem = new HashMap<>();

        for (String tu : chuoi) {
            Dem.put(tu,Dem.getOrDefault(tu,0)+1);
        }
        for (Map.Entry<String, Integer> entry: Dem.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
