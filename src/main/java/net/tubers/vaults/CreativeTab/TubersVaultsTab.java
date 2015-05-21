package net.tubers.vaults.CreativeTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.tubers.vaults.TubersVaults;
import net.tubers.vaults.blocks.VaultsBlocks;


public class TubersVaultsTab {

    public static final CreativeTabs TUBERS_VAULTS_TAB = new CreativeTabs("TubersVaults")
    {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(VaultsBlocks.ironVault);
        }
    };

}
