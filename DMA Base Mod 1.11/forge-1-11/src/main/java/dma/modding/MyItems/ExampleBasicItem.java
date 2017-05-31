package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExampleBasicItem extends Item 
{
	private final String name = "exampleBasicItem";
	
	public ExampleBasicItem()
	{	
		setRegistryName(name);
		setUnlocalizedName(BaseMod.MODID + "_" + name);
		setCreativeTab(ExampleCode.exampleTab);
		GameRegistry.register(this);
	}
	
	public String getName()
	{
		return name;
	}
}