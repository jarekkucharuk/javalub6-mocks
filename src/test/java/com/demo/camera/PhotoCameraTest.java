package com.demo.camera;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
public class PhotoCameraTest {

    @Test
    public void turningOnCameraTurnsOnSensor() {

        ImageSensor sensor=mock(ImageSensor.class);
        PhotoCamera camera=new PhotoCamera(sensor);
        camera.turnOn();
        Mockito.verify(sensor).turnOn();
    }
    @Test
    public void turningOffCameraTurnsOffSensor() {

        ImageSensor sensor = mock(ImageSensor.class);
        PhotoCamera camera = new PhotoCamera(sensor);
        camera.turnOff();
        Mockito.verify(sensor).turnOff();
    }

    @Test
    public void PressingButtonWhileCameraOffDoNothing(){

        ImageSensor sensor = mock(ImageSensor.class);
        Card card = mock(Card.class);
        PhotoCamera camera = new PhotoCamera(sensor);
        camera.turnOff();
        camera.pressButton();
        Mockito.verifyZeroInteractions(card);
    }



}