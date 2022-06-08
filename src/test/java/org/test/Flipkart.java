package org.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.base.BaseClass;
import org.login.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Flipkart extends BaseClass {

	public static void main(String[] args) throws InterruptedException {
		
	browserLaunch("chrome");
	urlLaunch("https://www.flipkart.com/");
	
	LoginPage l = new LoginPage();
	
	click(l.getClickLogin());
	
	sleep(3000);
	
	sendKeys(l.getTxtSearch(), "Iphone13");
	
	click(l.getBtnSearch());
	
	List<String> li = new ArrayList<String>();
	List<String> list1 = new ArrayList<>();
	List<String> list2 = new ArrayList<>();
	List<Integer> list3 = new ArrayList<>();
	
	sleep(3000);
	List<WebElement> elements = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
	System.out.println("Iphone Models");
	for(WebElement x:elements) {
		String text = x.getText();
		System.out.println(text);
	}
	
	List<WebElement> elements2 = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
	System.out.println("Iphone prices");
	for(WebElement x : elements2) {
		String text2 = x.getText();
		System.out.println(text2);
		
		
		li.add(text2);
//		System.out.println(text2);
	}
//	
	System.out.println("Remove comma----------");
	for(String x:li) {
		if(x.contains(",")) {
		list1.add(x.replace(",", ""));
		}
	}
	System.out.println(list1);

	
	System.out.println("Remove rupee symbol----------");
	for(String x:list1) {
	list2.add(x.substring(1));
	}
	System.out.println(list2);
	
	System.out.println("Change to Integer");
	for(String x :list2) {
		int pt = Integer.parseInt(x);
		list3.add(pt);
	}
	System.out.println(list3);
	
	Collections.sort(list3);
	System.out.println("Iphone prices in Ascending order-----");
	for(int x:list3) {
    System.out.println(x);
	}
	
	 System.out.println("----------Maximum Number--------------");
//	 System.out.println(list3.get(list3.size()-1));
	 System.out.println(Collections.max(list3));
	 
	 System.out.println("----------Minimum Number--------------");
	 System.out.println(Collections.min(list3));
	 
	quit();
	
	System.out.println("Done");
	
	}
	
}
  