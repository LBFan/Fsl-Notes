package lambdaandstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description :
 * @Author : fanshulin
 * @Date : 2020/5/30
 */
public class TestStreamAPI {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 999.99),
                new Employee("李四", 28, 555.55),
                new Employee("王五", 50, 999.89),
                new Employee("赵六", 16, 889.99),
                new Employee("田七", 18, 769.99),
                new Employee("刘八", 8, 1009.99),
                new Employee("刘八", 8, 1009.99),
                new Employee("刘八", 8, 1009.99)
        );
        /*1. 给定一个数字列表，返回由每个数字的平方组成的列表*/
        Integer[] nums = {1, 2, 3, 4, 5};
        List<Integer> list = Arrays.stream(nums).map(x -> x * x).collect(Collectors.toList());
    }

}
