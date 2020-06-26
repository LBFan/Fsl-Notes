package com.fan.zuoalgorithm.ch01.num04;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :  PF_23
 * @Description : 猫狗队列 使用两个队列同时保持主队列一致，只用时间戳表示顺序的一致性
 * @date : 2019/11/08.
 */

public class DogCatQueue {

    private static final String DOG = "dog";
    private static final String CAT = "cat";
    private Queue<PetEnterQueue> dogQ = new LinkedList<>();
    private Queue<PetEnterQueue> catQ = new LinkedList<>();
    private long count = 0;

    public void add(Pet pet) {
        if (DOG.equals(pet.getPetType())) {
            dogQ.add(new PetEnterQueue(pet, count++));
        } else if (CAT.equals(pet.getPetType())) {
            catQ.add(new PetEnterQueue(pet, count++));
        } else {
            throw new RuntimeException("error,not dog or cat");
        }
    }

    public Pet pollAll() {
        if (!dogQ.isEmpty() && !catQ.isEmpty()) {
            if (dogQ.peek().getCount() < catQ.peek().getCount()) {
                return dogQ.poll().getPet();
            } else {
                return catQ.poll().getPet();
            }
        } else if (!dogQ.isEmpty()) {
            return dogQ.poll().getPet();
        } else if (!catQ.isEmpty()) {
            return catQ.poll().getPet();
        } else {
            throw new RuntimeException("err,queue is empty");
        }
    }

    public Dog pollDog() {
        if (dogQ.isEmpty()) {
            throw new RuntimeException("Dog Queue is empty!");
        }
        return (Dog) dogQ.poll().getPet();
    }

    public Cat pollCat() {
        if (catQ.isEmpty()) {
            throw new RuntimeException("Cat Queue is empty!");
        }
        return (Cat) catQ.poll().getPet();
    }

    public Boolean isEmpty() {
        return catQ.isEmpty() && dogQ.isEmpty();
    }

    public Boolean isDogQueueEmpty() {
        return dogQ.isEmpty();
    }

    public Boolean isCatQueueEmpty() {
        return catQ.isEmpty();
    }
}

