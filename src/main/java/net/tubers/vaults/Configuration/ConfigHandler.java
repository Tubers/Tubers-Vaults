package net.tubers.vaults.Configuration;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static int STONE_VAULT_GEN;

	public static void init(File file)
	{
		Configuration config = new Configuration(file);
		
		config.load();
		
		STONE_VAULT_GEN = config.get("World Gen", "Stone Vault", 2).getInt();
		
		config.save();
	}
}
