package dma.modding.MyBlocks;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ExampleBasicBlock extends Block 
{
	private final String name = "examplebasicblock";
	//public static ItemBlock exampleBlockItem;
	
    public ExampleBasicBlock ()
    {
    	super(Material.ROCK);
    	setUnlocalizedName(BaseMod.MODID + "_" + name);
    	setCreativeTab(ExampleCode.exampleTab);
    	setSoundType(SoundType.STONE);
    }
   
	public String getName()
	{
		return name;
	}
	
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getBlockLayer()
	{
		return BlockRenderLayer.SOLID;
	}
}