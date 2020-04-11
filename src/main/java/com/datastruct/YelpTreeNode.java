package com.datastruct;

public class YelpTreeNode {
	public int loc;
	public String type;
	public YelpTreeNode left;
	public YelpTreeNode right;
	
	public YelpTreeNode(int loc, String type){
		this.loc = loc;
		this.type = type;
	}
}
