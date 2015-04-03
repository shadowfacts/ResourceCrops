package net.shadowfacts.resourcecrops.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * @author shadowfacts
 */
public class RCSeed extends Item implements IPlantable {

	private EnumPlantType plantType = EnumPlantType.Crop;

	public Block plant;
	public Block soil;

	public RCSeed(String name, Block plant) {
		this(name, plant, Blocks.farmland);
	}

	public RCSeed(String name, Block plant, Block soil) {
		this.setUnlocalizedName(name);
		this.plant = plant;
		this.soil = soil;
	}

	public RCSeed setPlantType(EnumPlantType type) {
		this.plantType = type;
		return this;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (ForgeDirection.getOrientation(side) == ForgeDirection.UP) { // Can only be planted on the top side of blocks
			Block soil = world.getBlock(x, y, z);
			if (soil.canSustainPlant(world, x, y, z, ForgeDirection.UP, this)) { // Is the soil block correct for the plant type
				world.setBlock(x, y + 1, z, plant, 0, 2);

				stack.stackSize--;
				if (stack.stackSize <= 0) {
					stack = null;
				}
			}
		}
		return false;
	}

	@Override
	public String getUnlocalizedName() {
		return "resourcecrops." + super.getUnlocalizedName();
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName();
	}

//	IPlantable
	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return plantType;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return plant;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}
}
