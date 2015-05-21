package net.tubers.vaults.interfaces;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotVault extends Slot {

	
	public SlotVault(IInventory inventory, int id, int x, int y) 
	{
		super(inventory, id, x, y);
	}
	
	@Override
	public boolean isItemValid(ItemStack stack)
	{
		return true;
	}

}
