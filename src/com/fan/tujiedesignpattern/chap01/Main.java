package com.fan.tujiedesignpattern.chap01;

/**
 * @Description :
 * @Author : fanshulin
 * @Date : 2020/6/2
 */
public class Main {
    public static void main(String[] args) {
        BookSelf bookSelf = new BookSelf(4);
        bookSelf.appendBook(new Book("Around the world"));
        bookSelf.appendBook(new Book("Bible"));
        bookSelf.appendBook(new Book("China"));
        bookSelf.appendBook(new Book("July"));

        Iterator  iterator = bookSelf.iterator();

        while (iterator.hasNext()) {
            Book book = (Book) iterator.next();
            System.out.println(book.getName());
        }
    }
}
