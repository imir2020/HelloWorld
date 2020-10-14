package ru.progwards.java1.lessons.interfaces;

public class Food implements CompareWeight{
    private int weight;

    public Food(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }
//    public double getWeight() {
//        return weight;
//    }
    @Override
    public CompareResult compareWeight(CompareWeight smthHasWeigt) {
        Food one = (Food) smthHasWeigt;//в параметре передаётся объект, записываемы в интерфейсную переменную.
        CompareResult result;
        //if(getWeight() < smthHasWeigt)
        return null;
    }

    //в параметре передаётся объект, записываемы в интерфейсную переменную.
    public static void sort(CompareWeight[] a){
        
    }
}
