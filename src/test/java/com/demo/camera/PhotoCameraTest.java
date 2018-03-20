package com.demo.camera;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
public class PhotoCameraTest {

    @Test
    public void turningOnCameraTurnsOnSensor() {

        Card card = mock(Card.class);
        ImageSensor sensor=mock(ImageSensor.class);
        PhotoCamera camera=new PhotoCamera(card, sensor);
        camera.turnOn();
        Mockito.verify(sensor).turnOn();
    }
    @Test
    public void turningOffCameraTurnsOffSensor() {

        Card card = mock(Card.class);
        ImageSensor sensor = mock(ImageSensor.class);
        PhotoCamera camera = new PhotoCamera(card,sensor);
        camera.turnOff();
        Mockito.verify(sensor).turnOff();
    }

    @Test
    public void pressingButtonWhileCameraOffDoNothing(){

        ImageSensor sensor = mock(ImageSensor.class);
        Card card = mock(Card.class);
        PhotoCamera camera = new PhotoCamera(card,sensor);
        camera.turnOff();
        camera.pressButton();
        Mockito.verifyZeroInteractions(card);
    }
    @Test
    public void pressingButtonWhileCameraOnWritesData() {
        byte []table={1,2,3};
        ImageSensor sensor = mock(ImageSensor.class);
        Card card = mock(Card.class);
        PhotoCamera camera = new PhotoCamera(card,sensor);
        camera.turnOn();
        camera.pressButton();
        sensor.read();
        Mockito.when(sensor.read()).thenReturn(table);
        Mockito.verify(card).write(Mockito.any());


    }
}