package com.sbk;

public class MeasureTime
{
    String description;
    long startTime;
    long endTime;

    public MeasureTime(String Description)
    {
        description = Description;
        startTime = 0;
        endTime = 0;
    }

    public void start()
    {
        System.out.println("\n" + getDescription() + " : Starting... ");
        startTime = System.nanoTime();
    }

    public void stop()
    {
        endTime = System.nanoTime();
        System.out.println("Stopping... ");
        printElapsedTime();
    }

    public void printElapsedTime()
    {
        System.out.println("Execution time = " + getElapsedTime() + "\n");
    }

    public long getElapsedTime()
    {
        return endTime - startTime;
    }

    public String getDescription()
    {
        return description;
    }

    public void showBestPerformance(MeasureTime first, MeasureTime second)
    {
        System.out.println("Best Solution: " + ((first.getElapsedTime() < second.getElapsedTime())?first.getDescription():second.getDescription()) );
    }
}
