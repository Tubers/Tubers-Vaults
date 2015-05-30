package net.tubers.vaults.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.tubers.vaults.items.ItemTV;
import net.tubers.vaults.items.Test;
import net.tubers.vaults.references.ModRef;
import net.tubers.vaults.utility.LogHelper;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


@GameRegistry.ObjectHolder(ModRef.ID)
public class ItemInit {

	public static List<ItemTV> itemRegList = new LinkedList<ItemTV>();


	//Instantiate
	public static ItemTV testItem = new Test();


	public static void loadItems()
	{
		// Register Items

		Iterator iterator = itemRegList.iterator();
		while (iterator.hasNext())
		{
			ItemTV regItem = (ItemTV)iterator.next();
			GameRegistry.registerItem(regItem, regItem.getRawName(), ModRef.ID);
			LogHelper.info("Registered: "+ regItem.getUnlocalizedName());
		}
		
	}

}
