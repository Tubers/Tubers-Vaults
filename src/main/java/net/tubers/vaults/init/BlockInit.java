package net.tubers.vaults.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.tileentity.TileEntity;
import net.tubers.vaults.blocks.BlockContainerTV;
import net.tubers.vaults.blocks.TileEntityTV;
import net.tubers.vaults.blocks.vault.iron.BlockIronVault;
import net.tubers.vaults.blocks.vault.iron.TileEntityIronVault;
import net.tubers.vaults.utility.LogHelper;

import java.util.Iterator;
import java.util.List;
import java.util.LinkedList;
import net.minecraft.tileentity.TileEntity;

public class BlockInit {

	public static List<BlockContainerTV> blockRegList = new LinkedList<BlockContainerTV>();
	
	public static BlockContainer ironVault = new BlockIronVault();

	public static void loadBlocks(){

		Iterator iterator = blockRegList.iterator();
		while (iterator.hasNext())
		{
			BlockContainerTV regBlock = (BlockContainerTV)iterator.next();
			GameRegistry.registerBlock(regBlock, regBlock.getUnlocalizedName());
			if (regBlock.getTileEntity()!= null)
			{

				Class<TileEntity> regTile = (Class<TileEntity>)regBlock.getTileEntity();
				GameRegistry.registerTileEntity(regTile, regTile.toString());
			}
			LogHelper.info("Registered: " + regBlock.getUnlocalizedName());


		}


		GameRegistry.registerTileEntity(TileEntityIronVault.class, "TileEntityIronVault");
	}

}
