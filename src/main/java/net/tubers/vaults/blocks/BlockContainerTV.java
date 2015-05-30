package net.tubers.vaults.blocks;



import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.tubers.vaults.creativetab.TubersVaultsTab;
import net.tubers.vaults.init.BlockInit;
import net.tubers.vaults.utility.LogHelper;

import java.lang.reflect.Constructor;


public abstract class BlockContainerTV extends BlockContainer {


    protected BlockContainerTV(Material p_i45394_1_, Class tileClass)
    {
        super(p_i45394_1_);
        setCreativeTab(TubersVaultsTab.TUBERS_VAULTS_TAB);
        BlockInit.blockRegList.add(this);
        setTileEntity(tileClass);
    }

    Class<?> tile = null;

    protected void setTileEntity(Class<?> tile)
    {
        this.tile = tile;
    }

    public Class<?> getTileEntity()
    {
        return tile;
    }

    @Override
    public TileEntity createNewTileEntity(World w, int i)
    {
        Class<?> c = getTileEntity();
        Constructor<?>[] constructors = c.getConstructors();
        Constructor<?> con = constructors[0];

        Object obj = null;

        try{
            obj = con.newInstance();
        }
        catch (Exception e)
        {
            LogHelper.error(e.getMessage());
        }
        return (TileEntityTV)obj;
    }

}
