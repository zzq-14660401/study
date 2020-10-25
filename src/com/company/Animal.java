package com.company;

public interface Animal {
    public int age=0;
    public boolean haveHare=true;
    public String clour="";
    public String name="";

    /**
     * 动物吃的食物
     * @param food 食物
     */
    public void eat(String food);

    /**
     * 动物的叫声
     */
    public void shot();



}
