package net.shadowfacts.resourcecrops.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;

/**
 * @author shadowfacts
 */
public class RCCrop extends BlockCrops {

	private ArrayList<ItemStack> grownDrops = new ArrayList<ItemStack>();
	private ItemStack seed;

	public RCCrop(String name, Item... items) {
		this.setBlockName(name);
		this.grownDrops.addAll(Arrays.asList(items));
	}

	public RCCrop(String name, Block... blocks) {
		this.setBlockName(name);
		this.grownDrops.addAll(Arrays.asList(blocks));
	}

	public RCCrop(String name, ItemStack... stacks) {
		this.setBlockName(name);
		grownDrops = new ArrayList<ItemStack>(Arrays.asList(stacks));
	}

	@Override
	public String getUnlocalizedName() {
		return "resourcecrops." + super.getUnlocalizedName();
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		if (metadata == 0) {
			ArrayList<ItemStack> list = new ArrayList<ItemStack>();
			list.add(seed);
			return list;
		} else {
			return grownDrops;
		}
	}
}
