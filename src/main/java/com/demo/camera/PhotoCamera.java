package com.demo.camera;

public class PhotoCamera {

    ImageSensor sensor;
    Card card;
    byte [] table={};


    public PhotoCamera(Card card,ImageSensor sensor) {
        this.card = card;
        this.sensor = sensor;
    }

    public void turnOn() {
        sensor.turnOn();
    }

    public void turnOff() {
        sensor.turnOff();
    }

    public void pressButton() {
      sensor.read();
      card.write(table);
    }

}

