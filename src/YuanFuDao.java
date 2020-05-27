import java.util.*;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2020/03/24.
 */

public class YuanFuDao {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int lineNumber = s.nextInt();
        int[][] a = new int[lineNumber][1000];
        for (int i = 0; i < lineNumber; i++) {
            System.out.println("===============");
            System.out.println("请输入一个数字");
            a[i][0] = s.nextInt();
            for (int j = 0; j < a[i][0]; j++) {
                System.out.println("请输入一个数字");
                a[i][j + 1] = s.nextInt();
            }
            System.out.println();
        }
        for (int i = 0; i < a.length; i++) {
            int groups = groups(a[i]);
            System.out.println(groups);
        }

    }


    public static int groups(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                heap.add(nums[i]);
            }
        }
        int res = 0;
        while (heap.size() >= 3) {
            int min1 = heap.poll();
            int min2 = heap.poll();
            int min3 = heap.poll();
            res++;
            if (min1 > 1) {
                heap.add(min1 - 1);
            }
            if (min2 > 1) {
                heap.add(min2 - 1);
            }
            if (min3 > 1) {
                heap.add(min3 - 1);
            }

        }



        return res;


    }
}


/*
  import java.util.*;
  public class Main {
      public static List<Integer> deleteNum(int m, int[] nums) {
          List<Integer> res = new ArrayList<>();
          Map<Integer, Integer> map = new HashMap<>();
          for (Integer stuNo : nums) {
              map.put(stuNo, map.getOrDefault(stuNo, 0) + 1);

          }
          for (Integer num : nums) {
              if (map.containsKey(num) && map.get(num) > m) {
                  map.remove(num);
              }
              if (map.containsKey(num)) {
                  res.add(num);
              }
          }
          return res;
      }

      public static void main(String[] args) {

          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int m = sc.nextInt();
          int a[] =  new int[n];
          for (int i = 0; i < a.length; i++) {
              a[i] = sc.nextInt();
          }
          List<Integer> list = deleteNum(m,a);
          for (int i = 0; i < list.size(); i++) {
              System.out.print(list.get(i)+" ");
          }
      }
  }
 */
