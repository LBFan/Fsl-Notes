package tujiedesignpattern.chap04.idcard;

import tujiedesignpattern.chap04.framework.Factory;
import tujiedesignpattern.chap04.framework.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : PF_23
 * @Description :
 * @date : 2020/06/04.
 */

public class IDCardFactory extends Factory {

    private List owners = new ArrayList();
    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }

    public List getOwners() {
        return owners;
    }
}
