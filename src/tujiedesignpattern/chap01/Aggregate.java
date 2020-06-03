package tujiedesignpattern.chap01;

/**
 * @Description :
 * @Author : fanshulin
 * @Date : 2020/6/2
 */
public interface Aggregate {
    /**
     * 返回一个iterator方法
     *
     * @return iterator
     */
    Iterator iterator();
}
