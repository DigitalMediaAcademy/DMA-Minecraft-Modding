package dma.modding.Other;

import java.util.Random;

import dma.modding.ExampleCode;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ExampleOreGenerator implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		// Runs 'generateNether' or 'generateSurface' depending on which dimension you're loading
		switch (world.provider.getDimension())
		{
			case -1:
				GenerateNether(world, random, chunkX*16, chunkZ*16);
				break;
			case 0:
				GenerateSurface(world, random, chunkX*16, chunkZ*16);
				break;
		}
		
	}
	
	
	public void GenerateSurface(World world, Random random, int x, int z)
	{
		this.AddOreSpawn(ExampleCode.exampleBasicBlock.getDefaultState(), world, random, x, z, 16, 16, 50, 20, 0, 256);
		this.AddOreSpawn(ExampleCode.exampleBasicBlock.getDefaultState(), world, random, x, z, 16, 16, 50, 20, 0, 256);
	}
	
	public void GenerateNether(World world, Random random, int x, int z)
	{
		// If you want to spawn this ore in the nether, add code similar to surface function
	}
	
	public void AddOreSpawn(IBlockState block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY, int maxY )
	{
		for(int i = 0; i < chancesToSpawn; i++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY -minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			BlockPos position = new BlockPos(posX, posY, posZ);
			new WorldGenMinable(block, maxVeinSize).generate(world, random, position);
		}
	}

	
}