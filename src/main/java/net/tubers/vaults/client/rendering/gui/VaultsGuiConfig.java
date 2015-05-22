package net.tubers.vaults.client.rendering.gui;


import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import net.minecraft.client.gui.GuiScreen;

import java.util.List;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.tubers.vaults.handler.ConfigHandler;
import net.tubers.vaults.references.ConfigRef;
import net.tubers.vaults.references.Reference;

public class VaultsGuiConfig extends GuiConfig {


    public VaultsGuiConfig(GuiScreen parentScreen)
    {
       super(parentScreen,
               new ConfigElement<Object>(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
               Reference.ID,
               false,
               false,
               ConfigRef.GUI_CONFIG_TITLE);
    }
}
