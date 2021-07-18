import java.io.IOException;
import java.util.Scanner;

public class A11052 {
   public static void main(String[] args) throws NumberFormatException, IOException {
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         
         // n개의 카드팩배열 초기화
         int[] cardpack = new int[n+1];
         // 가격 배열
         int[] maxprice = new int[n+1];
         for(int i=1; i<cardpack.length; i++) {
            cardpack[i] = sc.nextInt();
         }
         
         
         // 3장을 예로 들면
         
         
         // 0번 배열엔 아무것도 있지않음
         
         // 카드팩 1장짜리 가격 + 2장을 사기위한 최대값
         // 카드팩 2장짜리 가격 + 1장을 사기위한 최대값
         // 카드팩 3장가격
         
         // 비교해서 최대값 배열에 넣어준다
         
           for(int i = 1; i <=n; i++) {
               for(int j = 1; j <=i; j++) {
                   maxprice[i] = Math.max(maxprice[i],cardpack[j]+maxprice[i-j]);
               }
           }
           System.out.println(maxprice[n]);
       }
         
               
   }