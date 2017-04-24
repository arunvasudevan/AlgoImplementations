package com.homeaway;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.datastruct.YelpTreeNode;

public class YelpSearchTest {
	YelpTreeNode root;
	YelpSearch yelpSearch;

	@Before
	public void setUp() throws Exception {
		root = new YelpTreeNode(4, "Restaurants");
		
		final YelpTreeNode lRoot = new YelpTreeNode(2, "Gym");
		final YelpTreeNode ll = new YelpTreeNode(1, "Restaurants");
		final YelpTreeNode lr = new YelpTreeNode(3, "Restaurants");
		lRoot.left = ll;
		lRoot.right = lr;
				
		final YelpTreeNode rRoot = new YelpTreeNode(6, "Restaurants");
		final YelpTreeNode rl = new YelpTreeNode(5, "Gym");
		final YelpTreeNode rr = new YelpTreeNode(7, "Restaurants");
		rRoot.left = rl;
		rRoot.right = rr;
				
		root.left = lRoot;
		root.right = rRoot;
		
		yelpSearch = new YelpSearch(root);
	}

	@Test
	public void testNearestRestaurants() {
		System.out.println("----------------------------------------------------");
		System.out.println("Test Nearest Restaurant");
		System.out.println("----------------------------------------------------");
		final YelpTreeNode actualResult = yelpSearch.findNearestLocbyType(4, "Restaurants");
		
		final YelpTreeNode expResult = new YelpTreeNode(3, "Restaurants");
		
		System.out.println("Location of the Nearest Node:"+actualResult.loc+ " Type:"+actualResult.type);
		
		assertEquals(actualResult.loc, expResult.loc);	
	}
	
	@Test
	public void testUnavailableLocation() {
		System.out.println("----------------------------------------------------");
		System.out.println("Test Unavailable Location");
		System.out.println("----------------------------------------------------");
		final YelpTreeNode actualResult = yelpSearch.findNearestLocbyType(9, "Restaurants");
		
		final YelpTreeNode expResult = new YelpTreeNode(7, "Restaurants");
		
		System.out.println("Location of the Nearest Node:"+actualResult.loc+ " Type:"+actualResult.type);
		
		assertEquals(actualResult.loc, expResult.loc);
	}
	
	@Test
	public void testUnavailableType() {
		System.out.println("----------------------------------------------------");
		System.out.println("Test Unavailable Type");
		System.out.println("----------------------------------------------------");
		final YelpTreeNode actualResult = yelpSearch.findNearestLocbyType(7, "Coffee Shop");
		
		final YelpTreeNode expResult = null;
		
		System.out.println("Location of the Nearest Node:"+actualResult+ " Type:"+actualResult);
		
		assertEquals(actualResult, expResult);
	}
}
