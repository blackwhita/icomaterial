package com.blackwhita.icomaterial.item;

import com.blackwhita.icomaterial.IcoMaterial;
import com.blackwhita.icomaterial.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, IcoMaterial.MODID);

    public static Item.Properties getDefaultProperties() {
        return new Item.Properties().tab(ModTab);
    }    public static final RegistryObject<Item> ITEM_DEMO = ITEMS.register("item_demo", () -> new Item(getDefaultProperties()));

    public static final RegistryObject<Item> BLOCK_DEMO = ITEMS.register("block_demo", () -> new BlockItem(ModBlocks.BLOCK_DEMO.get(), getDefaultProperties()));

    public static CreativeModeTab ModTab = new CreativeModeTab(IcoMaterial.MODID) {
        @Override
        @NotNull
        public ItemStack makeIcon() {
            return new ItemStack(ITEM_DEMO.get());
        }
    };


}
