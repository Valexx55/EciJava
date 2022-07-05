package edu.tech.val.courses.jee;

public class Calcula implements Proceso
{
    public Object ejecuta()
    {
        return (int)(Math.random()*100.0);
    }
}