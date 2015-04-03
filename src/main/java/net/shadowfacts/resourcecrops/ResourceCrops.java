package net.shadowfacts.resourcecrops;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.shadowfacts.resourcecrops.proxy.CommonProxy;
import net.shadowfacts.shadowcore.Log;

/**
 * Main mod file.
 * @author shadowfacts
 */
@Mod(modid = ResourceCrops.modId, name = ResourceCrops.displayName, version = ResourceCrops.version, dependencies = ResourceCrops.depString)
public class ResourceCrops {

	public static final String modId = "resourcecrops";
	public static final String displayName = "ResourceCrops";
	public static final String version = "@VERSION@";
	public static final String clientProxyString = "net.shadowfacts.resourcecrops.proxy.ClientProxy";
	public static final String serverProxyString = "net.shadowfacts.resourcecrops.proxy.CommonProxy";
	public static final String depString = "required-after:shadowcore@1.0.1;";

	@Mod.Instance(ResourceCrops.modId)
	public static ResourceCrops instance;

	@SidedProxy(clientSide = ResourceCrops.clientProxyString, serverSide = ResourceCrops.serverProxyString)
	public static CommonProxy proxy;

	// Logger
	public static final Log log = new Log(modId);

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
