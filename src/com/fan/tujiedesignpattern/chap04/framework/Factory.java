package com.fan.tujiedesignpattern.chap04.framework;

/**
 * @author : PF_23
 * @Description :
 * @date : 2020/06/04.
 */

public abstract class Factory {
    public final Product create(String owner) {
        Product p = createProduct(owner);
        registerProduct(p);
        return p;
    }

    protected abstract Product createProduct(String owner);

    protected abstract void registerProduct(Product product);
}

