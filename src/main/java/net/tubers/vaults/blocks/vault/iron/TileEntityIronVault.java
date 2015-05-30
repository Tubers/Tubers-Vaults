package net.tubers.vaults.blocks.vault.iron;

import java.util.Iterator;
import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.tubers.vaults.blocks.TileEntityTV;
import net.tubers.vaults.blocks.vault.iron.BlockIronVault;
import net.tubers.vaults.blocks.vault.iron.ContainerVault;

public class TileEntityIronVault extends TileEntityTV implements IInventory {
	public float prevLidAngle;
	public float lidAngle;
	public float prevWheelAngle;
	public float wheelAngle;
	
	public int facing;
    public int numPlayersUsing;
    private int ticksSinceSync;

    private ItemStack[] chestContents;
	
	public TileEntityIronVault()
	{
		chestContents = new ItemStack[12];
		numPlayersUsing = 0;
	}
	
	public int getFacing()
	{
		return this.blockMetadata;
	}
	
	public void setFacing(int facing)
	{
		this.facing = facing;
	}
	
	public void updateEntity()
    {
        super.updateEntity();
        ++this.ticksSinceSync;
        float f;
        

        if (!this.worldObj.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + this.xCoord + this.yCoord + this.zCoord) % 200 == 0)
        {
            this.numPlayersUsing = 0;
            f = 5.0F;
            List<EntityPlayer> list = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, AxisAlignedBB.getBoundingBox((double)((float)this.xCoord - f), (double)((float)this.yCoord - f), (double)((float)this.zCoord - f), (double)((float)(this.xCoord + 1) + f), (double)((float)(this.yCoord + 1) + f), (double)((float)(this.zCoord + 1) + f)));
            Iterator iterator = list.iterator();

            while (iterator.hasNext())
            {
                EntityPlayer entityplayer = (EntityPlayer)iterator.next();

                if (entityplayer.openContainer instanceof ContainerVault)
                {
                	IInventory iinventory = ((ContainerVault)entityplayer.openContainer).getLowerVaultInventory();

                    if (iinventory != null)
                    {
                        ++this.numPlayersUsing;
                    }
                }
            }
        }
        
        this.prevLidAngle = this.lidAngle;
        f = 0.05F;
        double d2;
        if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F)
        {
            double d1 = (double)this.xCoord + 0.5D;
            d2 = (double)this.zCoord + 0.5D;
            this.worldObj.playSoundEffect(d1, (double)this.yCoord + 0.5D, d2, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
        }
        if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F)
        {
            float f1 = this.lidAngle;

            if (this.numPlayersUsing > 0)
            {
            	
                this.lidAngle += f;
            }
            else
            {
                this.lidAngle -= f;
                
            }

            if (this.lidAngle > 1.0F)
            {
                this.lidAngle = 1.0F;
            }
            float f2 = 0.5F;
            if (this.lidAngle < f2 && f1 >= f2)
            {
                d2 = (double)this.xCoord + 0.5D;
                double d0 = (double)this.zCoord + 0.5D;
                this.worldObj.playSoundEffect(d2, (double)this.yCoord + 0.5D, d0, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
            }
            if (this.lidAngle < 0.0F)
            {
                this.lidAngle = 0.0F;
            }
        }
    }

	@Override
	public int getSizeInventory() 
	{
		return chestContents.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) 
	{
		return chestContents[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		ItemStack stack = getStackInSlot(index);
		if(stack != null)
		{
			if (stack.stackSize <= count)
			{
				setInventorySlotContents(index, null); 
			}
			else
			{
				stack = stack.splitStack(count);
				this.markDirty();
			}
		}
		return stack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		if (chestContents[index] != null)
        {
            ItemStack itemstack = chestContents[index];
            chestContents[index] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		chestContents[index] = stack;
		if (stack != null && stack.stackSize > getInventoryStackLimit())
		{
			chestContents[index].stackSize = getInventoryStackLimit();
		}
		this.markDirty();
	}

	@Override
	public String getInventoryName() 
	{
		return "Vault Inventory";
	}

	@Override
	public boolean hasCustomInventoryName() 
	{
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) <= 64;
	}

	@Override
	public void openInventory() 
	{
		if (this.numPlayersUsing < 0)
        {
            this.numPlayersUsing = 0;
        }

        ++this.numPlayersUsing;
        this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numPlayersUsing);
	}

	@Override
	public void closeInventory() 
	{
		if (this.getBlockType() instanceof BlockIronVault)
        {
            --this.numPlayersUsing;
            this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numPlayersUsing);
        }
	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		return true;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		
		NBTTagList chestContents = new NBTTagList();
		
		for(int i=0; i< getSizeInventory(); i++)
		{
			ItemStack stack = getStackInSlot(i);
			
			if (stack != null)
			{
				//NBTHelper.setString();
				NBTTagCompound item = new NBTTagCompound();
				item.setByte("Slot", (byte)i);
				stack.writeToNBT(item);
				chestContents.appendTag(item);
			}
		}
		compound.setTag("chestContents", chestContents);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		
		NBTTagList chestContents = compound.getTagList("chestContents", compound.getId());
		
		for (int i = 0; i < chestContents.tagCount(); i++)
		{
			NBTTagCompound item = (NBTTagCompound)chestContents.getCompoundTagAt(i);
			int slot = item.getByte("Slot");
			
			if (slot >= 0 && slot < getSizeInventory())
			{
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
			}
		}
	}
}
