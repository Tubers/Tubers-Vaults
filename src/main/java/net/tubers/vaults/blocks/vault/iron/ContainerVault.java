package net.tubers.vaults.blocks.vault.iron;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerVault extends Container {
	
	private TileEntityIronVault vault;
	private IInventory lowerVaultInventory;
	
	public ContainerVault(InventoryPlayer inventory, TileEntityIronVault vault)
	{
		this.lowerVaultInventory = vault;
		this.vault = vault;
		this.vault.openInventory();
		for(int x=0; x<9; x++)//hotbar
		{
			addSlotToContainer(new Slot(inventory, x, 8 + 18 * x, 142));
		}
		
		for(int y = 0; y < 3; y++)//player Inventory
		{
			for(int x = 0; x < 9; x++)
			{
				addSlotToContainer(new Slot(inventory, x + y * 9 + 9, 8 + 18 * x, 84 + 18 * y));
			}
		}
		
		for(int y = 0; y < 3; y++)//vault Inventory
		{
			for(int x = 0; x < 4; x++)
			{
				addSlotToContainer(new SlotVault(vault, x + y * 4, 53 + 18 * x, 17 + 18 * y));
			}
		}
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return vault.isUseableByPlayer(player);
	}
	
	public ItemStack transferStackInSlot(EntityPlayer player, int i)
	{
		return null;
	}

	public void onContainerClosed(EntityPlayer player)
    {
        super.onContainerClosed(player);
        this.vault.closeInventory();
    }

	public IInventory getLowerVaultInventory() {
		return this.lowerVaultInventory;
	}
}
