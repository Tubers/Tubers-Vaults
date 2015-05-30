package net.tubers.vaults.generation;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;

import java.util.HashMap;
import java.util.Random;


public class VaultGenHooks {



    public static final WeightedRandomChestContent[] STONE_VAULT_CONTENTS =
            new WeightedRandomChestContent[]
            {
            new WeightedRandomChestContent(Items.lava_bucket, 0, 1, 1, 10),
            new WeightedRandomChestContent(Items.water_bucket, 0, 1, 1, 10),
            new WeightedRandomChestContent(Items.brewing_stand, 0, 1, 1, 10),
            new WeightedRandomChestContent(Items.cake, 0, 1, 1, 10),
            new WeightedRandomChestContent(Items.painting, 0, 1, 1, 10),
            new WeightedRandomChestContent(Items.bed, 0, 1, 1, 10)
            };

    public static final int STONE_LOOT_AMOUNT = 4;


    /*
    public static void generateChestContents(Random p_76293_0_, WeightedRandomChestContent[] p_76293_1_, IInventory p_76293_2_, int p_76293_3_)
    {
        for (int j = 0; j < p_76293_3_; ++j)
        {
            WeightedRandomChestContent weightedrandomchestcontent = (WeightedRandomChestContent) WeightedRandom.getRandomItem(p_76293_0_, p_76293_1_);
            ItemStack[] stacks = weightedrandomchestcontent.generateChestContent(p_76293_0_, p_76293_2_);

            for (ItemStack item : stacks)
            {
                p_76293_2_.setInventorySlotContents(p_76293_0_.nextInt(p_76293_2_.getSizeInventory()), item);
            }
        }
    }
    */



}
