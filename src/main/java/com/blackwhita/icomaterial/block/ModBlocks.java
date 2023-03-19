package com.blackwhita.icomaterial.block;

import com.blackwhita.icomaterial.IcoMaterial;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, IcoMaterial.MODID);

    public static final RegistryObject<Block> BLOCK_DEMO = BLOCKS.register("block_demo", () -> new Block(getDefaultProperties()));

    public static BlockBehaviour.Properties getDefaultProperties() {
        return BlockBehaviour.Properties.of(Material.STONE)
                .requiresCorrectToolForDrops()
                .strength(3.0F);
    }

}
