package com.demo.camera;
import org.assertj.core.api.Assertions;
import org.junit.Test;
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

}