package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExampleSpade extends ItemSpade
{
	private final String name = "exampleSpade";
	
	public ExampleSpade(ToolMaterial material)
	{
		super(material);
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