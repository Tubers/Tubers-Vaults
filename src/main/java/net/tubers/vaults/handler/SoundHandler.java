package net.tubers.vaults.handler;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SoundHandler {
	
	SoundHandler(){
		MinecraftForge.EVENT_BUS.register(this);
	}

	
	public void onSoundsLoad(SoundLoadEvent event)
	{
		
	}
	
	private void addSound(SoundLoadEvent event, String name)
	{
	//event.manager.
	}
}
