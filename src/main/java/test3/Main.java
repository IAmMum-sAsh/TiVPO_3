package test3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import javax.swing.*;

public class Main extends JFrame {
    Executor executor;
    JTextField textFieldHour = new JTextField();
    JTextField textFieldMinute = new JTextField();

    public Main(){
        JPanel panelN = new JPanel();
        JButton btnPlay = new JButton("Set");
        JButton btnPause = new JButton("Stop"); btnPause.setVisible(false);

        panelN.add(btnPause);
        panelN.add(btnPlay);

        JPanel panelC = new JPanel();
        textFieldHour.setColumns(7);
        textFieldMinute.setColumns(7);
        this.updateTextFields();

        panelC.add(textFieldHour);
        panelC.add(textFieldMinute);

        JPanel panelV = new JPanel();
        JLabel label = new JLabel("", SwingConstants.CENTER);
        label.setSize(this.getWidth(), this.getHeight());
        //label.setText(updateLabel(1));

        panelV.add(label);

        Container container = this.getContentPane();
        BorderLayout layout = new BorderLayout();
        container.setLayout(layout);
        container.add(panelV, BorderLayout.NORTH);
        container.add(panelC, BorderLayout.CENTER);
        container.add(panelN, BorderLayout.SOUTH);


        btnPlay.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        boolean flag = true;
                        int hour = 0; int minute = 0;

                        try {
                            hour = Integer.parseInt(textFieldHour.getText());
                            minute = Integer.parseInt(textFieldMinute.getText());
                        } catch (Exception exception) {
                            flag = false;
                            //label.setText(updateLabel(2));
                        }

                        if(hour>23 || minute>59){
                            flag = false;
                        }

                        if(flag){
                            //label.setText(updateLabel(3));
                            btnPlay.setVisible(false);
                            textFieldHour.setVisible(false);
                            textFieldMinute.setVisible(false);
                            btnPause.setVisible(true);

                            executor = new Executor(new PlayerThread());
                            executor.setDelay(textFieldHour.getText(), textFieldMinute.getText());

                            try {
                                executor.run();
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            } catch (ExecutionException executionException) {
                                executionException.printStackTrace();
                            }
                        }
                    }
                }
        );

        btnPause.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        executor.stop();
                        updateTextFields();
                        btnPlay.setVisible(true);
                        textFieldHour.setVisible(true);
                        textFieldMinute.setVisible(true);
                        btnPause.setVisible(false);
                        //label.setText(updateLabel(1));
                    }
                }
        );

        this.setVisible(true);
        this.setSize(250, 150);
        this.setTitle("MP3 Player");
        this.setLocation(100, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateTextFields(){
        Date date = new Date();
        textFieldHour.setText(String.valueOf(date.getHours()));
        textFieldMinute.setText(String.valueOf(date.getMinutes()+1));
    }

//    public String updateLabel(int param){
//        String resp = new String();
//        if(param == 1){resp = "Укажите время будильника!";}
//        else if(param == 2){resp = "Ошибка ввода!";}
//        else if(param == 3){resp = "Будильник установлен!";}
//        return resp;
//    }


    public static void main(String[] args) {
        Main main = new Main();
    }
}
