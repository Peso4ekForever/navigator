package ru.peso4ek;

public class NavigationAgent implements Runnable {
    private final int TRACE_LENGTH; //В метрах
    private final Car CAR;

    public NavigationAgent(int traceLength, Car car) {
        this.TRACE_LENGTH = traceLength;
        this.CAR = car;
    }

    @Override
    public void run() {
        double traceLengthLeftover = TRACE_LENGTH; //Оставшийся путь
        int time = 0; //Тикер
        double midSpeed = 0.0; //Средняя скорость

        double timeLeftover = 0.0;

        while (traceLengthLeftover >= 0) {
            double localCarSpeed = CAR.getCarSpeed();

            time += 1;
            traceLengthLeftover -= localCarSpeed;

            if(traceLengthLeftover < 0){
                break;
            }

            //Средняя скорость
            midSpeed = (TRACE_LENGTH - traceLengthLeftover) / time;

            timeLeftover = traceLengthLeftover / localCarSpeed;

            System.out.printf("Скорость: %f, Время: %d, Оставшийся путь: %f, Средняя скорость: %f, Оставшееся время: %f%n",
                    localCarSpeed, time, traceLengthLeftover, midSpeed, timeLeftover);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
