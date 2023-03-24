package practice.hospital;

import net.sf.saxon.functions.Compare;

import java.math.BigDecimal;
import java.util.Locale;

public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float [] patientsTemperatures = new float[patientsCount];
        float scale = (float) Math.pow(10, 1);
        for (int i = 0; i < patientsCount; i++) {
            float floatVariable = (float) (Math.random()/Math.nextDown(1.0));
            float test = (float) (40*(1.0-floatVariable)+32*floatVariable);
            patientsTemperatures [i] = (float) Math.ceil(test * scale) / scale;
        }
        return patientsTemperatures;
    }
    public static String getReport(float[] temperatureData) {
        double epsilon = 0.0001;
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
            Округлите среднюю температуру с помощью Math.round до 2 знаков после запятой,
            а температуры каждого пациента до 1 знака после запятой
        */
        Locale.setDefault(new Locale("en"));
        float averageTemperature;
        float summTemperature = 0.00f;
        String patientsTemperatures = "";
        String textAverageTemperature;
        int healthyPatients = 0;
        for (int i = 0; i < temperatureData.length; i++) {
            String temperatureText = String.valueOf(temperatureData[i]);
            if (i == temperatureData.length - 1) {
                patientsTemperatures += temperatureText;
            } else {
                patientsTemperatures += temperatureText + " ";
            }
            summTemperature += temperatureData[i];
            Boolean minTemperature = Math.abs(temperatureData[i] - 36.2) < epsilon;
            Boolean maxTemperature = Math.abs(temperatureData[i] - 36.9) < epsilon;
            if (minTemperature ||
                    maxTemperature ||
                    temperatureData[i] > 36.2 && temperatureData[i] < 36.9) {
                healthyPatients++;
            }
        }
        averageTemperature = summTemperature / (temperatureData.length);
        textAverageTemperature = String.format("%.2f", averageTemperature);
        String report =
            "Температуры пациентов: " + patientsTemperatures +
            "\nСредняя температура: " + textAverageTemperature +
            "\nКоличество здоровых: " + healthyPatients;

        return report;
    }
}
