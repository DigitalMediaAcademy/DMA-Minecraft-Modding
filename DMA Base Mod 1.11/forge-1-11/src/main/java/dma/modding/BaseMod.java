package dma.modding;

import net.minecraft.client.renderer.ItemModelMesher;
//import net.minecraft.client.renderer.entity.RenderItem;
//import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import dma.modding.ExampleCode;
import dma.modding.Other.ExampleOreGenerator;

@Mod(modid = BaseMod.MODID, version = BaseMod.VERSION)

public class BaseMod
{	
	// Metadata for Forge to recognize your unique mod
    public static final String MODID = "examplemod";
    public static final String VERSION = "1.0.0";
		
    // The instance of your mod that Forge uses.
    @Instance(value = "ExampleModID")
    public static BaseMod instance;

    // Says where the client and server 'proxy' code is loaded.
    @SidedProxy(clientSide="dma.modding.Client.ClientProxy", serverSide="dma.modding.CommonProxy")
    public static CommonProxy proxy;
        
    @EventHandler
    public void PreInit(FMLPreInitializationEvent event)
    {
    	// Load Blocks and Items First
    	ExampleCode.CreateBlocks();
    	ExampleCode.CreateItems();
    	
    	MyCode.CreateBlocks();
    	MyCode.CreateItems();
    }
        
    @EventHandler
    public void Init(FMLInitializationEvent event)
    {
    	// Load Renderers, Recipes, and Generators Next
    	if(event.getSide() == Side.CLIENT)
    	{
	    	ExampleCode.RenderItems();
	    	MyCode.RenderItems();
    	}
        proxy.registerRenderers();
        GameRegistry.registerWorldGenerator(new ExampleOreGenerator(), 1);
        
        ExampleCode.CreateRecipes();
        MyCode.CreateRecipes();
    } 
    
    @SideOnly(Side.CLIENT)
    public static void initClient(ItemModelMesher mesher){
    	
    }
        
    @EventHandler
    public void PostInit(FMLPostInitializationEvent event)
    {
    	// This is used for loading content that interacts with other mods.
    	// We won't be using it this week - Leave Empty!
    }
}