package lambdaandstream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description :
 * @Author : fanshulin
 * @Date : 2020/5/28
 */
public class TestLambda {

    public static void main(String[] args) {
        // 原来的匿名内部类
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        // lambda
        Comparator<Integer> comL = (o1, o2) -> Integer.compare(o2, o1);

        List<Employee> employees = Arrays.asList(
                new Employee("张三", 18, 999.99),
                new Employee("李四", 28, 555.55),
                new Employee("王五", 50, 999.89),
                new Employee("赵六", 16, 889.99),
                new Employee("田七", 18, 769.99),
                new Employee("刘八", 8, 1009.99)
        );

        // 需求： 获取当前公司中员工年龄大于35岁工资>=5000的员工信息
        List<Employee> employeeList = employees.stream().
                filter(e -> e.getAge() >= 5000).
                filter(e -> e.getAge() > 35).
                collect(Collectors.toList());
    }

}
