package dma.modding;

// Java Imports


// Minecraft Imports
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
// Block Imports
import dma.modding.MyBlocks.ExampleBasicBlock;
// Item Imports
import dma.modding.MyItems.ExampleArmor;
import dma.modding.MyItems.ExampleBasicItem;
import dma.modding.MyItems.ExampleSpade;
import dma.modding.MyItems.ExampleSword;

// Other Imports
import dma.modding.Other.ExampleCreativeTab;


public class ExampleCode
{
	// Block Declarations
	public static Block exampleBasicBlock;
	
	// Material Declarations
	public static ToolMaterial exampleToolMaterial = EnumHelper.addToolMaterial("exampleToolMaterial", 3, 192, 5.0F, 1.5F, 12);
	public static ArmorMaterial exampleArmorMaterial = EnumHelper.addArmorMaterial("exampleArmorMaterial", "examplemod:example", 20, new int[] {6, 16, 12, 6}, 12, null, 0);
		
	// Item Declarations
	public static Item exampleBasicItem;
	public static Item exampleSword;
	public static Item exampleSpade;
	public static ItemArmor exampleHelmet;
	public static ItemArmor exampleChestplate;
	public static ItemArmor exampleLeggings;
	public static ItemArmor exampleBoots;
	
	// Creative Tab Declarations
	public static CreativeTabs exampleTab = new ExampleCreativeTab(BaseMod.MODID);

	
	public static void CreateBlocks()
	{
		// Basic Block Example
		exampleBasicBlock = new ExampleBasicBlock();
		ResourceLocation resourceLocation = new ResourceLocation(BaseMod.MODID, 
				((ExampleBasicBlock)exampleBasicBlock).getName());
		exampleBasicBlock.setRegistryName(resourceLocation);
		GameRegistry.register(exampleBasicBlock);
		GameRegistry.register(new ItemBlock(exampleBasicBlock), resourceLocation);
		
		// Any new additional blocks should be implemented the same way
		
	}
	
	public static void CreateItems()
	{
		// Basic Item (Minecraft Example: stick)
		exampleBasicItem = new ExampleBasicItem();
		
		// Tools
		exampleSword = new ExampleSword(exampleToolMaterial);
		exampleSpade = new ExampleSpade(exampleToolMaterial);
		
		// Armor
		exampleHelmet = new ExampleArmor(exampleArmorMaterial, 0, EntityEquipmentSlot.HEAD);
		exampleChestplate = new ExampleArmor(exampleArmorMaterial, 0, EntityEquipmentSlot.CHEST);
		exampleLeggings = new ExampleArmor(exampleArmorMaterial, 0, EntityEquipmentSlot.LEGS);
		exampleBoots = new ExampleArmor(exampleArmorMaterial, 0, EntityEquipmentSlot.FEET);
	}
	
	public static void CreateRecipes()
	{
		// Shapeless (Minecraft Example: 1 Log -> 4 Wood Planks)
		GameRegistry.addShapelessRecipe(new ItemStack(Items.STICK, 3), new Object[] { new ItemStack(Blocks.SAPLING)});
		
		// Shaped (Minecraft Example: 4 Planks -> Crafting Table)
		GameRegistry.addRecipe(new ItemStack(exampleBasicBlock, 3), new Object[]
		{
			"AAA",
			"ABA",
			"AAA",
			'A', exampleBasicItem,
			'B', Items.STICK,
		});
		 
		// Smelting (Minecraft Example: Cobblestone + Furnace -> Stone)
		GameRegistry.addSmelting(exampleBasicItem, new ItemStack(Items.BEEF, 5), 5.0f);
		
		
		// Enchanting (Crafting an item with a default enchantment)
		ItemStack enchantedSword = new ItemStack(Items.DIAMOND_SWORD);
		enchantedSword.addEnchantment(Enchantments.SHARPNESS, 4);
		
		GameRegistry.addRecipe(enchantedSword, new Object[] 
		{
			"S", "R", 
			'S', Items.DIAMOND_SWORD,
			'R', Items.REDSTONE
		});
	}
	
	public static void RenderItems()
	{
		
	    RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
	    
		// Blocks
	    // Blocks are rendered in a really specific way. Everything below needs to be done for every block.
	    Item exampleBasicBlockItem = Item.getItemFromBlock(exampleBasicBlock);
	    ModelResourceLocation model = new ModelResourceLocation(
	    		BaseMod.MODID + ":" + ((ExampleBasicBlock) exampleBasicBlock).getName(), "inventory");
    	ModelLoader.registerItemVariants(exampleBasicBlockItem, model);
    	renderItem.getItemModelMesher().register(exampleBasicBlockItem, 0, model);
  
		// Items
    	renderItem.getItemModelMesher().register(exampleBasicItem, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleBasicItem) exampleBasicItem).getName(), "inventory"));    	
    	renderItem.getItemModelMesher().register(exampleSword, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleSword) exampleSword).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(exampleSpade, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleSpade) exampleSpade).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(exampleHelmet, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleArmor) exampleHelmet).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(exampleChestplate, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleArmor) exampleChestplate).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(exampleLeggings, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleArmor) exampleLeggings).getName(), "inventory"));
    	renderItem.getItemModelMesher().register(exampleBoots, 0, new ModelResourceLocation(BaseMod.MODID + ":" + ((ExampleArmor) exampleBoots).getName(), "inventory"));
	}
}
