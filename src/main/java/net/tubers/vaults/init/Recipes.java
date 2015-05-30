package net.tubers.vaults.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Recipes {

    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(ItemInit.testItem), " s ", "sss", " s ", 's', new ItemStack(Items.carrot));
        GameRegistry.addShapelessRecipe(new ItemStack(ItemInit.testItem), new ItemStack(ItemInit.testItem), new ItemStack(ItemInit.testItem));
    }
}
