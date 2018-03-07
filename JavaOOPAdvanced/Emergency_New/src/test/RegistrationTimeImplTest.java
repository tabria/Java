package test;

import bg.softuni.contracts.RegistrationTime;
import bg.softuni.utils.RegistrationTimeImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//test if the class is returning correct String

public class RegistrationTimeImplTest {

    private static final String INVALID_TIME ="78:35 18/04/2017";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getMinutes() throws Exception {
    }

    @Test (expected = IllegalArgumentException.class)
    public void getHour() throws Exception {
        RegistrationTime hours = new RegistrationTimeImpl(INVALID_TIME);
    }

    @Test
    public void getDay() throws Exception {
    }

    @Test
    public void getMonth() throws Exception {
    }

    @Test
    public void getYear() throws Exception {
    }



}