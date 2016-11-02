package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;


import org.junit.Ignore;
import org.junit.Test;

import com.lesson.Calculator;

public class TestCalculator {

	private static Calculator calculator;
	@BeforeClass
	
	public static void init(){
		calculator = new Calculator();
	}
	@AfterClass
	public static void destroy(){
		calculator = null;
		
	}
//	@Ignore
	@Test
	public void testAdd(){
		
		int real = calculator.add(5, 5);
		int expected = 10;
		
		
		
		
//		Assert.assertEquals(expected, real);
		if (real != expected){
			Assert.fail("hahahaha");
		}
	}
	@Test
	public void testSubstruct(){
		Assert.assertEquals("error substruct", calculator.subsruct(10, 5), 3, 0.1);
	}
//	@Test
//	public void testMultiply(){
//		Assert.assertEquals(calculator.multiply(10, 5);
//	}
//	@Test
//	public void testDevide(){
//		Assert.assertEquals(calculator.devide(10, 5);
//	}
	
	@Before
	public void beforEveryTest(){
		System.out.println("befor every test");
	}
	@After
	public void afterEveryTest(){
		System.out.println("after every test");
	}
	
	@Test(expected=FileNotFoundException.class)
	public void real() throws FileNotFoundException{
		FileInputStream fileInputStream = new FileInputStream("test.txt");
		
	}
}

