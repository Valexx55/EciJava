package edu.tech.val.courses.jee;

public class Concatenacion implements Proceso
{
    public Object ejecuta()
    {
        return new StringBuilder().append("Hola ").append(" mundo");
    }
}