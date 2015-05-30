package net.tubers.vaults.blocks.vault.iron;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.tubers.vaults.blocks.BlockContainerTV;
import net.tubers.vaults.blocks.BlocksRef;
import net.tubers.vaults.TubersVaults;
import net.tubers.vaults.blocks.TileEntityTV;
import net.tubers.vaults.utility.LogHelper;

import java.lang.reflect.Constructor;

public class BlockIronVault extends BlockContainerTV {
	
	

	public BlockIronVault() 
	{
		super(Material.anvil, TileEntityIronVault.class);
		setBlockName(BlocksRef.IRON_VAULT_NAME);
		setBlockBounds(0.0625F, 0F, 0.0625F, 
					   0.9375F, 1.0F, 0.9375F);
		this.setHardness(1000F);
		setStepSound(Block.soundTypeMetal);
	}
	
	public int damageDropped(int amount)
    {
        return amount;
    }




	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public int getRenderType()
	{
		return -1;
	}
	
	
	public int getVaultID()
	{
		return getIdFromBlock(this); // id can be different with different mods loaded.
	}
	
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack p_149689_6_)
    {
		
		byte b0 = 0;
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		if (l == 0)
        {
            b0 = 3;
        }

        if (l == 1)
        {
            b0 = 4;
        }

        if (l == 2)
        {
            b0 = 2;
        }

        if (l == 3)
        {
            b0 = 5;
        }
        world.setBlockMetadataWithNotify(x, y, z, b0, 3);
    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitx, float hity, float hitz)
    {
        if (!world.isRemote)//server
        {
        	// perhaps have two interfaces channel 0 and 1.
        	// 0 for the security and 1 that shows the contents 
        	FMLNetworkHandler.openGui(player, TubersVaults.instance, 0, world, x, y, z);
        	
        	//int newMeta = world.getBlockMetadata(x, y, z) == 0 ? 1 : 0;
        	//world.setBlockMetadataWithNotify(x, y, z, newMeta, 3);
        }
        return true;
    }
	
	public void breakBlock(World world, int x, int y, int z, Block id, int meta)
	{
		TileEntity te = world.getTileEntity(x, y, z);
		if(te != null && te instanceof IInventory)
		{
			IInventory inventory = (IInventory)te;
			
			for (int i = 0; i < inventory.getSizeInventory();i++)
			{
				ItemStack stack = inventory.getStackInSlotOnClosing(i);
				
				if (stack != null)
				{
					float spawnX = x + world.rand.nextFloat();
					float spawnY = y + world.rand.nextFloat();
					float spawnZ = z + world.rand.nextFloat();
					
					EntityItem droppedItem = new EntityItem(world, spawnX, spawnY, spawnZ, stack);
					
					float mult = 0.05F;
					
					droppedItem.motionX = (-0.5 + world.rand.nextFloat())*mult;
					droppedItem.motionY = (4 + world.rand.nextFloat())*mult;
					droppedItem.motionZ = (-0.5 + world.rand.nextFloat())*mult;
					
					world.spawnEntityInWorld(droppedItem);
					
				}
			}
		}
		
		super.breakBlock(world, x, y, z, id, meta);
	}
	
	 @SideOnly(Side.CLIENT)
	 public void registerBlockIcons(IIconRegister var1)
	 {
		 this.blockIcon = var1.registerIcon("stone");
	 }


}
