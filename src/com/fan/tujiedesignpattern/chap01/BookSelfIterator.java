package com.fan.tujiedesignpattern.chap01;

/**
 * @Description :
 * @Author : fanshulin
 * @Date : 2020/6/2
 */
public class BookSelfIterator implements Iterator {
    private BookSelf bookSelf;
    private int index;

    public BookSelfIterator(BookSelf bookSelf) {
        this.bookSelf = bookSelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < bookSelf.getLength()) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Book book = bookSelf.getBookAt(index);
        index++;
        return book;
    }
}
