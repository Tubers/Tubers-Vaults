package net.tubers.vaults.blocks.vault.iron;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.tubers.vaults.references.ModRef;
import net.tubers.vaults.blocks.vault.iron.ContainerVault;
import net.tubers.vaults.blocks.vault.iron.TileEntityIronVault;

import org.lwjgl.opengl.GL11;

public class GuiVault extends GuiContainer{

	public GuiVault(InventoryPlayer player, TileEntityIronVault vault) 
	{
		super(new ContainerVault(player, vault));
		xSize = 176;
		ySize = 166;
	}
	//ResourceLocation(ModRef.ID, "textures/guis/vaultGui.png");
	private static final ResourceLocation texture = new ResourceLocation(ModRef.ID, "textures/guis/VaultGui.png");
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int x, int y) 
	{
		GL11.glColor4f(1, 1, 1, 1);
		
		mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
	}
	

}
