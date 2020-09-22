package com.qa.Pages;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomStringAndNumberGenerator {
	public static void main(String args[])
	{
		RandomStringAndNumberGenerator obj = new RandomStringAndNumberGenerator();
		String output  = obj.randomIntGeneration();
		System.out.println(output);
		
	}
	public String randomIntGeneration() {
		//String randomNumber = RandomStringUtils.random(2);
	//	String randomNumber = RandomStringUtils.random(2);
		String randomNumber = RandomStringUtils.randomGraph(5);
	//	String randomNumber = RandomStringUtils.randomNumeric(3);
	    // String randomNumber = RandomStringUtils.randomAscii(3);
		//String randomNumber = RandomStringUtils.randomAlphabetic(2);
		return randomNumber;
		
	}
  }

