package br.alvaro.testekafka;

public class App 
{
    public static void main( String[] args )
    {
       ConsumerRunnable runnable = new ConsumerRunnable();
       runnable.run();
    }
}
