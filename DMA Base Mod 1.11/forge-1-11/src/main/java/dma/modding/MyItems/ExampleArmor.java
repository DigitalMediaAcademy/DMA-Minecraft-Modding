package dma.modding.MyItems;

import dma.modding.BaseMod;
import dma.modding.ExampleCode;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
//EntityEquipment is Organized as:
// TYPE | Index | SlotIndex | name
//MAINHAND(EntityEquipmentSlot.Type.HAND, 0, 0, "mainhand"),
//OFFHAND(EntityEquipmentSlot.Type.HAND, 1, 5, "offhand"),
//FEET(EntityEquipmentSlot.Type.ARMOR, 0, 1, "feet"),
//LEGS(EntityEquipmentSlot.Type.ARMOR, 1, 2, "legs"),
//CHEST(EntityEquipmentSlot.Type.ARMOR, 2, 3, "chest"),
//HEAD(EntityEquipmentSlot.Type.ARMOR, 3, 4, "head");

public class ExampleArmor extends ItemArmor
{
	private final String name = "example";
	private String armorTypeName = "";
	
	public ExampleArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType)
	{
		super(material, renderIndex, armorType);
		
		switch (armorType.getSlotIndex())
		{
		case 4:
			armorTypeName = "Helmet";
			break;
			
		case 3:
			armorTypeName = "Chestplate";
			break;
			
		case 2:
			armorTypeName = "Leggings";
			break;
			
		case 1:
			armorTypeName = "Boots";
			break;
		}
		
		setUnlocalizedName(BaseMod.MODID + "_" + name + armorTypeName);
		setRegistryName(name+armorTypeName);
		setCreativeTab(ExampleCode.exampleTab);
		
		GameRegistry.register(this);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (slot == 4 ||slot == 1 || slot == 3)
		{
			return (BaseMod.MODID + ":textures/models/armor/example_layer_1.png");
		}
		else if (slot == 2)
		{
			return (BaseMod.MODID + ":textures/models/armor/example_layer_2.png");
		}
		else
		{
			return null;
		}
	}

	public String getName()
	{
		return (name + armorTypeName);
	}
}