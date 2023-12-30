package hyundai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _8979 {
    private static int n,k;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        List<Country> countryList = new ArrayList<>();
        Country target=null;
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++){
            st = new StringTokenizer(bf.readLine());
            int index = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            if(index==k){
                target = new Country(index, gold, silver, bronze);
            }else{
                countryList.add(new Country(index, gold, silver, bronze));
            }
        }

        int count=1;
        for(int i=0; i<n-1; i++){
            if(compare(target, countryList.get(i))<0){
                count++;
            }
        }
        System.out.println(count);
    }

    static int compare(Country a, Country b){
        if(a.gold!=b.gold){
            return a.gold-b.gold;
        }
        if(a.silver!=b.silver){
            return a.silver-b.silver;
        }
        return a.bronze-b.bronze;
    }

    private static class Country{
        int gold, silver, bronze, index;

        public Country(int index, int gold, int silver, int bronze){
            this.index = index;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}
