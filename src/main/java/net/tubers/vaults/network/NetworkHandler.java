package net.tubers.vaults.network;


import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.tubers.vaults.references.ModRef;

public class NetworkHandler {

    public static SimpleNetworkWrapper network;

    public static void init()
    {
        network = NetworkRegistry.INSTANCE.newSimpleChannel(ModRef.ID);
        //network.registerMessage(, MyMessage.class, 0, Side.SERVER);
    }

}
