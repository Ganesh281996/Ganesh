/**
 * Purpose managing inventory of rice pulse and wheat using json
 * @author Ganesh
 * @since 16 March 2018
 */
package com.bridgelabz.objectoriented;

import com.bridgelabz.utility.Utility;

public class InventoryManagement 
{
	public static void main(String[] args) 
	{
		String path="/home/bridgeit/Ganesh/BasicProject/Files/RicePulseWheat.json";
		Utility.inventoryManagement(path);
	}
}