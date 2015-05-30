package net.tubers.vaults.generation;

import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.tubers.vaults.blocks.vault.iron.TileEntityIronVault;
import net.tubers.vaults.init.BlockInit;
import net.tubers.vaults.utility.LogHelper;

import java.util.Random;


public class WorldGenVault extends WorldGenerator{

    private World world;
    private int x;
    private int y;
    private int z;


    public WorldGenVault()
    {

    }

    private int findAir()
    {
        //0 = South
        //1 = West
        //2 = North
        //3 = East
        //north block is x,y,z-1
        //south block is x,y,z+1
        //west block is x-1,y,z
        //east block is x+1,y,z
        int facing = -1;
        for (int k = -1; k <= 1; k += 2) {
            if (this.world.isAirBlock(this.x + k, this.y, this.z)) {
                return facing = (k<0) ? 1 : 3;

            }
            if (world.isAirBlock(this.x, this.y, this.z + k)) {
                return facing = (k<0) ? 2 : 0;
            }
        }
        return facing;
    }

    @Override
    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        /*
        world.provider.hasNoSky
        for(int k =)
        world.isAirBlock()
        */
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;

        /*
        int k = 1;
        while (world.isAirBlock(x,y-k,z)) {k++;} //find a solid surface
        */
        if(!world.getBlock(x,y,z).isReplaceable(world,x,y,z))
        {
            LogHelper.info("Coordinates: " + x + ", " + y + ", " + z);
            /*
            world.setBlock(x, y, z, Blocks.chest, 0, 2);
            TileEntityChest tileentitychest = (TileEntityChest)world.getTileEntity(x, y, z);

            if (tileentitychest != null)
            {
                tileentitychest.setInventorySlotContents(1, new ItemStack(Items.baked_potato, 1, 0));
                //
            }
            */

            world.setBlock(x, y, z, BlockInit.ironVault, 0, 2);
            TileEntityIronVault tileVault = (TileEntityIronVault)world.getTileEntity(x, y, z);
            if (tileVault != null)
            {
                //tileVault.setInventorySlotContents(1, new ItemStack(Items.baked_potato,1,0));
                //WeightedRandomChestContent.generateChestContents(rand, VaultGenHooks.getItems(VaultGenHooks.VAULT_SPAWN_NORMAL, rand), tileVault, VaultGenHooks.getCount(VaultGenHooks.VAULT_SPAWN_NORMAL, rand));
                WeightedRandomChestContent.generateChestContents(rand, VaultGenHooks.STONE_VAULT_CONTENTS, tileVault, VaultGenHooks.STONE_LOOT_AMOUNT);
            }

        }
        return true;
    }

}
