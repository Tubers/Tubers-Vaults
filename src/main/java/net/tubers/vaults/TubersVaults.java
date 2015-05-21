package net.tubers.vaults;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.tubers.vaults.Configuration.ConfigHandler;
import net.tubers.vaults.CreativeTab.TubersVaultsTab;
import net.tubers.vaults.Items.VaultsItems;
import net.tubers.vaults.blocks.VaultsBlocks;
import net.tubers.vaults.interfaces.GuiHandler;
import net.tubers.vaults.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.tubers.vaults.references.Reference;

@Mod(modid = Reference.ID, version = Reference.VERSION, name = Reference.NAME)
public class TubersVaults {
	
	@SidedProxy(clientSide = "net.tubers.vaults.proxies.ClientProxy", serverSide = "net.tubers.vaults.proxies.CommonProxy")
	public static CommonProxy proxy;


	@Instance(Reference.ID)
	public static TubersVaults instance;

	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
	
		ConfigHandler.init(e.getSuggestedConfigurationFile());
		VaultsItems.loadItems();
		VaultsBlocks.loadBlocks();
		
		proxy.registerProxies();
		//proxy.initSounds();
		//proxy.initRenderers();
	}
	
	@Mod.EventHandler
	 public void init(FMLInitializationEvent e){
		//Items.addNames();
		//Blocks.addNames();
		
		//Items.registerRecipes();
		
		//Blocks.registerTileEntities();

		//Entites.init();
		// new GenerationHandler();
		new GuiHandler();
		
	 }
	
	@Mod.EventHandler
	public void modsLoaded(FMLPostInitializationEvent event)
	{
		
	}

}
