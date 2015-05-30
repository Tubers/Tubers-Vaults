package net.tubers.vaults.blocks;


import net.minecraft.tileentity.TileEntity;
import net.tubers.vaults.init.BlockInit;

import java.util.LinkedList;
import java.util.List;
import java.lang.reflect.*;

public class TileEntityTV extends TileEntity {


    protected TileEntityTV()
    {
        super();
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName();
    }


}
