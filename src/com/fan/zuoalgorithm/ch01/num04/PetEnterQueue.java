package com.fan.zuoalgorithm.ch01.num04;

/**
 * @author :  PF_23
 * @Description :
 * @date : 2019/11/08.
 */

public class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getCount() {
        return this.count;
    }

    public String getEnterType() {
        return this.pet.getPetType();
    }
}

