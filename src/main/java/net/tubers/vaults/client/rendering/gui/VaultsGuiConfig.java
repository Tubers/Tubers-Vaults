package net.tubers.vaults.client.rendering.gui;


import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;

import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.tubers.vaults.handler.ConfigHandler;
import net.tubers.vaults.references.ConfigRef;
import net.tubers.vaults.references.ModRef;

public class VaultsGuiConfig extends GuiConfig {


    public VaultsGuiConfig(GuiScreen parentScreen)
    {
       super(parentScreen,
               new ConfigElement<Object>(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
               ModRef.ID,
               false,
               false,
               ConfigRef.GUI_CONFIG_TITLE);
    }
}
