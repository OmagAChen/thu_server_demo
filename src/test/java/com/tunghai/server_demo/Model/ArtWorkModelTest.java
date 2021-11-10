package com.tunghai.server_demo.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArtWorkModelTest {

    @Test
    public void testID(){
        ArtWorkModel artWorkModel = new ArtWorkModel();
        artWorkModel.setId(1);
        Integer expected = 1;
        Integer actual = artWorkModel.getId();

        assertEquals(expected, actual);
    }

    @Test
    public void testART_NAME(){
        ArtWorkModel artWorkModel = new ArtWorkModel();
        artWorkModel.setArtName("test");
        String expected = "test";
        String actual = artWorkModel.getArtName();

        assertEquals(expected, actual);
    }

    @Test
    public void testAUTHOR(){
        ArtWorkModel artWorkModel = new ArtWorkModel();
        artWorkModel.setAuthor("test");
        String expected = "test";
        String actual = artWorkModel.getAuthor();

        assertEquals(expected, actual);
    }

    @Test
    public void testOVER_VIEW(){
        ArtWorkModel artWorkModel = new ArtWorkModel();
        artWorkModel.setOverView("test");
        String expected = "test";
        String actual = artWorkModel.getOverView();

        assertEquals(expected, actual);
    }

    @Test
    public void testCREAT_DATE(){
        ArtWorkModel artWorkModel = new ArtWorkModel();
        artWorkModel.setCreateDate("test");
        String expected = "test";
        String actual = artWorkModel.getCreateDate();

        assertEquals(expected, actual);
    }

}
