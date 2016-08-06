/**
 * 
 */
package ru.alexst.certification.ocp.par11.collections.testerrors;

/**
 * @author Алексей
 *
 */
public class Number6 {

}

interface Hungry<E> {
    void munch(E x);
}

interface Carnivore<E extends AbstractAnimal> extends Hungry<E> {
}

interface Herbivore<E extends AbstractPlant> extends Hungry<E> {
}

abstract class AbstractPlant {
}

class Grass extends AbstractPlant {
}

abstract class AbstractAnimal {
}

/*
 * class Sheep extends Animal implements Herbivore<Sheep> { public void munch(Sheep x) {} }
 */
class Wolf extends AbstractAnimal implements Carnivore<Sheep> {
    public void munch(Sheep x) {
    }
}

class Sheep extends AbstractPlant implements Carnivore<Wolf> {
    public void munch(Wolf x) {
    }
}
