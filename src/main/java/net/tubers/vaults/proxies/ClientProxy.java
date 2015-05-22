package net.tubers.vaults.proxies;

import net.tubers.vaults.blocks.TileEntityIronVault;
import net.tubers.vaults.renderer.tileentity.TileEntityIronVaultRenderer;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	public void registerProxies(){
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityIronVault.class,
				new TileEntityIronVaultRenderer());
	}

}
