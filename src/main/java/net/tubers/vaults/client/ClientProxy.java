package net.tubers.vaults.client;

import net.tubers.vaults.blocks.vault.iron.TileEntityIronVault;
import cpw.mods.fml.client.registry.ClientRegistry;
import net.tubers.vaults.CommonProxy;
import net.tubers.vaults.blocks.vault.iron.TileEntityIronVaultRenderer;

public class ClientProxy extends CommonProxy {
	
	public void registerProxies(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronVault.class,
				new TileEntityIronVaultRenderer());
	}

}
