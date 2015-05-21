package net.tubers.vaults.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;

public class VaultsBlocks {
	
	public static BlockContainer ironVault;
	
	public static void loadBlocks(){
		
		ironVault = new BlockIronVault();
		GameRegistry.registerBlock(ironVault, ironVault.getUnlocalizedName());
		GameRegistry.registerTileEntity(TileEntityIronVault.class, "TileEntityIronVault");
	}

}
