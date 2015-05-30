package net.tubers.vaults.blocks.vault.iron;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.tubers.vaults.references.ModRef;

public class TileEntityIronVaultRenderer extends TileEntitySpecialRenderer {

	
	private static final ResourceLocation ironVaultTexture = new ResourceLocation(ModRef.ID,"models/ironvault.png");
	private ModelIronVault model = new ModelIronVault();
	
	public TileEntityIronVaultRenderer()
	{
		
	}
	
	
	public void render(TileEntityIronVault tile, double x, double y, double z, float partialTick) 
	{
		if (tile == null)
		{
			return;
		}
		short facing = (short)tile.getFacing();
		
		GL11.glPushMatrix();
		
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		
		GL11.glTranslatef((float)x, (float)y + 1.0F, (float)z + 1.0F);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
			
		short k = 0;
		if (facing ==2){
			k = 180;
		}
		if (facing ==3){
			k = 0;
		}
		if (facing ==4){
			k = 90;
		}
		if (facing ==5){
			k = -90;
		}
		GL11.glRotatef((float)k, 0.0F, 1.0F, 0.0F);
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		
		float lidangle = tile.prevLidAngle + (tile.lidAngle - tile.prevLidAngle) * partialTick;
		lidangle = 1.0F - lidangle;
		lidangle = 1.0F - lidangle*lidangle*lidangle;
		model.vaultDoor.rotateAngleY = (lidangle* (float)Math.PI / 2.0F);
		
		bindTexture(ironVaultTexture);
		model.renderAll();
		
		GL11.glDisable(GL12.GL_RESCALE_NORMAL);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}


	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float partialTick) 
	{
		render((TileEntityIronVault) tileentity, x, y, z, partialTick);
	}
	
}
