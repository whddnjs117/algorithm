import java.util.Scanner;

public class A16194 {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      
      int n = sc.nextInt();
      
      // n개의 카드팩배열 초기화
      int[] cardpack = new int[n+1];
      // 가격 배열
      int[] minprice = new int[n+1];
      
      
      // 최소값을 비교하기때문에 최소값 배열에 0이아닌 n장팩의 가격을 넣는다

      for(int i=1; i<cardpack.length; i++) {
         cardpack[i] = sc.nextInt();
         minprice[i] = cardpack[i];
      }
      
      
      // ex)
      // 
      // 먼저 1번째 방에는 1장짜리 카드팩 가격이 들어가있다
      // Math.min 메서드를 사용해서 두 값을 비교해 최소값을 minprice[1] (1장을 사기위한 최소값) 에 넣어준다
      // minprice[1] , (cardpack[1] + minprice[1-1]) 두 값을 비교
      // minprice[1-1] 즉 0번째 배열에는 아무 값도 존재하지 않아서 카드팩 1장짜리 가격과 1장을 사기위한 최소값을 비교해 최소값을 배열에 넣어준다
        
      // 3장을 예로 들면
      // 카드팩1장짜리 가격 + (3-1)장을 사기위한 최소값
      // 카드팩2장짜리 가격 + (3-2)장을 사기위한 최소값
      // 카드팩3장짜리 가격 ... 을 i 와 j 값이 같아질때까지 반복해 최소값을 구한다
      for(int i = 1; i <=n; i++) {
            for(int j = 1; j <=i; j++) {
                minprice[i] = Math.min(minprice[i],cardpack[j]+minprice[i-j]);
            }
        }
        System.out.println(minprice[n]);
    }
      
   }
