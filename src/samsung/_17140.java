package samsung;

import java.util.*;
import java.io.*;

public class _17140 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken())-1;
        int c = Integer.parseInt(st.nextToken())-1;
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[100][100];

        for(int i=0; i<3; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int time=0, curX=3, curY=3, max;
        PriorityQueue<Number> queue = new PriorityQueue<>((o1,o2)->{
            if(o1.count!=o2.count){
                return o1.count-o2.count;
            }
            return o1.number - o2.number;
        });
        Map<Integer, Integer> hashMap = new HashMap<>();

        while(time<=100){

            if(map[r][c]==k){
                System.out.println(time);
                return;
            }

            max = 0;

            // R 연산
            if(curX>=curY){
                for(int i=0; i<curX; i++){
                    hashMap.clear();

                    // 몇개인지 카운트
                    for(int j=0; j<curY; j++){
                        if(map[i][j]!=0){
                            if(hashMap.containsKey(map[i][j])){
                                hashMap.put(map[i][j], hashMap.get(map[i][j])+1);
                            }else{
                                hashMap.put(map[i][j], 1);
                            }
                        }
                    }

                    // 정렬해서 다시 집어 넣음
                    for(int num: hashMap.keySet()){
                        queue.add(new Number(num, hashMap.get(num)));
                    }

                    Number number;
                    int index=0;
                    while(!queue.isEmpty()&&index<100){
                        number = queue.poll();
                        map[i][index++] = number.number;
                        map[i][index++] = number.count;
                    }
                    while(index<100){
                        map[i][index++]=0;
                    }

                    // 최대값 갱신
                    max = Math.min(Math.max(max, hashMap.size()*2),100);
                }
                curY =max;
            }
            // C 연산
            else{
                for(int i=0; i<curY; i++){
                    hashMap.clear();

                    // 몇개인지 카운트
                    for(int j=0; j<curX; j++){
                        if(map[j][i]!=0){
                            if(hashMap.containsKey(map[j][i])){
                                hashMap.put(map[j][i], hashMap.get(map[j][i])+1);
                            }else{
                                hashMap.put(map[j][i], 1);
                            }
                        }
                    }

                    // 정렬해서 다시 집어 넣음
                    for(int num: hashMap.keySet()){
                        queue.add(new Number(num, hashMap.get(num)));
                    }

                    Number number;
                    int index=0;
                    while(!queue.isEmpty()){
                        number = queue.poll();
                        map[index++][i] = number.number;
                        map[index++][i] = number.count;
                    }
                    while(index<100){
                        map[index++][i]=0;
                    }

                    // 최대값 갱신
                    max = Math.min(Math.max(max, hashMap.size()*2),100);
                }
                curX =max;
            }

            time++;
        }
        System.out.println("-1");
    }

    static class Number{
        int count;
        int number;

        public Number(int number, int count){
            this.count = count;
            this.number = number;
        }
    }
}
