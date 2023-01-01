package programus;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("7676", "76"));
    }

    public static int solution(String t, String p) {
        int answer = 0;
        int length = p.length();

        while (t.length() >= p.length()) {
            String number = t.substring(0, length);
            t = t.substring(1);
            if (p.compareTo(number)>=0)
                answer++;
        }
        return answer;
    }
}
