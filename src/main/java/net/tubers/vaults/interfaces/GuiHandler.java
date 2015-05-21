package net.tubers.vaults.interfaces;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.tubers.vaults.TubersVaults;
import net.tubers.vaults.blocks.ContainerVault;
import net.tubers.vaults.blocks.TileEntityIronVault;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

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
				return new GuiVault(player.inventory, (TileEntityIronVault) te);
			}
			break;
		}
		return null;
	}
	

}
