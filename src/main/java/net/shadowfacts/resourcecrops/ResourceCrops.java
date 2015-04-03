package net.shadowfacts.resourcecrops;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.shadowfacts.resourcecrops.block.RCCrop;
import net.shadowfacts.resourcecrops.item.RCSeed;
import net.shadowfacts.resourcecrops.proxy.CommonProxy;
import net.shadowfacts.shadowcore.Log;
import net.shadowfacts.shadowcore.config.ConfigManager;

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

//	Logger
	public static final Log log = new Log(modId);


	public static RCCrop ironCrop;
	public static RCSeed ironSeed;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
//		Config stuff
		ConfigManager.instance.register("ResourceCrops", RCConfig.class);
		ConfigManager.instance.load("ResourceCrops");

		ironCrop = new RCCrop("ironCrop", Items.iron_ingot, ironSeed);
		ironCrop.setCreativeTab(CreativeTabs.tabMisc);
		ironSeed = new RCSeed("ironSeed", ironCrop);
		ironSeed.setCreativeTab(CreativeTabs.tabMisc);

		GameRegistry.registerBlock(ironCrop, "ironCrop");
		GameRegistry.registerItem(ironSeed, "ironSeed");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
