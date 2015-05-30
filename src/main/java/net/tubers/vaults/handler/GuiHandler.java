package net.tubers.vaults.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.tubers.vaults.TubersVaults;
import net.tubers.vaults.blocks.vault.iron.ContainerVault;
import net.tubers.vaults.blocks.vault.iron.TileEntityIronVault;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import net.tubers.vaults.blocks.vault.iron.GuiVault;

public class GuiHandler implements IGuiHandler{
	
	public GuiHandler()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(TubersVaults.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) 
	{
		switch(ID) 
		{
		case 0:
			TileEntity te = world.getTileEntity(x,y,z);
			if(te != null && te instanceof TileEntityIronVault)
			{
				return new ContainerVault(player.inventory, (TileEntityIronVault) te);
			}
			break;
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(ID) 
		{
		case 0:
			TileEntity te = world.getTileEntity(x,y,z);
			if(te != null && te instanceof TileEntityIronVault)
			{
				// GUIVault also creates a container
				return new GuiVault(player.inventory, (TileEntityIronVault) te);
			}
			break;
		}
		return null;
	}
	

}
