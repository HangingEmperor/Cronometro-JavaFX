package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class Controller implements Initializable, Runnable {

    @FXML
    Button btnTime;
    @FXML
    Label labelTitleBase;
    @FXML
    Label labelTitleTimes;
    @FXML
    Label labelTimes;
    @FXML
    Button btnStop;
    @FXML
    Button btnStart;

    private boolean isTimerRunning;
    private int secondTotal;
    private int second;
    private int hour;
    private int minute;
    private Timer miTemporizador;
    private TimerTask task;

    Thread hilo;
    Boolean cronometroActivo;

    @FXML
    public void onClickStartButton() {
        cronometroActivo = true;
        hilo = new Thread(this);
        hilo.start();
    }

    @FXML
    public void onClickStopButton() {
        cronometroActivo = false;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void printTime(int hour, int minute, int second) {
        String fullHour = "";

        fullHour += (hour > 9) ? ":" + hour : "0" + hour;
        fullHour += (minute > 9) ? ":" + minute : ":0" + minute;
        fullHour += (second > 9) ? ":" + second : ":0" + second;
    }

    @Override
    public void run() {
        isTimerRunning = true;
        secondTotal++;
        second++;

        if (second > 59) {
            second = 0;
            minute++;
            if (minute > 60) {
                minute = 0;
                hour++;
                if (hour > 24) {
                    System.out.println("Are you crazy?");
                }
            }
        }
        if (secondTotal == 100000000) {
            isTimerRunning = false;
            System.exit(0);
        }
        if (isTimerRunning) {
            labelTitleBase.setText("Hola");
            //this.printTime(hour, minute, second);
        }
    }
}
