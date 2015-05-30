package net.tubers.vaults.handler;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;
import net.tubers.vaults.generation.WorldGenVault;

public class GenerationHandler implements IWorldGenerator {

	private WorldGenerator vaultGen;
	
	//need ID
	public GenerationHandler()
	{
		GameRegistry.registerWorldGenerator(this, 0);
		vaultGen = new WorldGenVault();
		//vaultGen = new WorldGenMinable(BlockInit.ironVault,1);
	}

	private void generateNormalVault(Random rand, int chunkX, int chunkZ, World world, int iterations, WorldGenerator vault, int lowestY, int highestY)
	{
		for (int i = 0; i < iterations; i++) {
			int x = chunkX * 16 + rand.nextInt(16);
			int y = lowestY + rand.nextInt(highestY - lowestY);
			int z = chunkZ * 16 + rand.nextInt(16);

			vault.generate(world, rand, x, y, z);

		}
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		if(world.provider.dimensionId == 0) //only generate in overworld
		{
			generateNormalVault(random, chunkX, chunkZ, world, 1, vaultGen, 50, 60);
		}

	}

	
}
