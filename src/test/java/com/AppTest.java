package com;

import java.io.IOException;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	@Test
    public void test() throws IOException {
		GlanceQuery gq = new GlanceQuery();
		SortedMap<String, Integer> testData = new TreeMap<String, Integer>();
		int date = 20130821;
		int count = 25;
		testData.put(String.valueOf(date), count);
		for (int i = 0; i < 10; i++) {
			date++;
			count++;
			testData.put(String.valueOf(date), count);
		}
		gq.calculateChangeInViews(testData);
		
		date = 201308;
		count = 10;
		testData.put(String.valueOf(date), count);
		for (int i = 0; i < 10; i++) {
			date++;
			count = count + 2;
			testData.put(String.valueOf(date), count);
		}
		gq.calculateChangeInViews(testData);
    }
}
