package net.tubers.vaults.handler;

import java.io.File;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.common.config.Configuration;
import net.tubers.vaults.references.ConfigRef;
import net.tubers.vaults.references.ModRef;

public class ConfigHandler {

	public static Configuration config;
	
	public static int stoneVault = ConfigRef.STONE_VAULT_DEFAULT;

	public static void init(File file)
	{
		if (config == null)
		{
			config = new Configuration(file);
			loadConfiguration();
		}

	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(ModRef.ID))
		{
			loadConfiguration();
		}
	}

	private static void loadConfiguration()
	{
		stoneVault = config.get(Configuration.CATEGORY_GENERAL,
				"Stone Vault", ConfigRef.STONE_VAULT_DEFAULT,"Comment in config").getInt(ConfigRef.STONE_VAULT_DEFAULT);

		if (config.hasChanged())
		{
			config.save();
		}
	}
}
