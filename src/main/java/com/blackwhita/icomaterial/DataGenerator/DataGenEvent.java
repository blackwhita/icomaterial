package com.blackwhita.icomaterial.DataGenerator;

import com.blackwhita.icomaterial.DataGenDemo;
import com.blackwhita.icomaterial.IcoMaterial;
import com.blackwhita.icomaterial.block.ModBlocks;
import com.blackwhita.icomaterial.datagen.loottable.ModLootTableProvider;
import com.blackwhita.icomaterial.datagen.tags.ModBlockTagsProvider;
import com.blackwhita.icomaterial.item.ModItems;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = IcoMaterial.MODID)
public class DataGenEvent {
    @SubscribeEvent
    public static <GatherDataEvent> void register(GatherDataEvent event) {
        ExistingFileHelper helper = event.getExistingFileHelper();
        if (event.includeClient()) {
            //block/item models, blockstates, language files...
            event.getGenerator().addProvider(new ModBlockStateProvider(event.getGenerator(),
                    DataGenDemo.MODID, helper, ModBlocks.BLOCKS));
            event.getGenerator().addProvider(new ModItemModelProvider(event.getGenerator(),
                    DataGenDemo.MODID, helper, ModItems.ITEMS));
            event.getGenerator().addProvider(new ModLanguageProvider(event.getGenerator(),
                    DataGenDemo.MODID, "en_us"));
        }
        if (event.includeServer()) {
            //recipes,advancements,tags...
            event.getGenerator().addProvider(new ModLootTableProvider(event.getGenerator(),
                    DataGenDemo.MODID));
            event.getGenerator().addProvider(new ModWorldgenProvider(event.getGenerator()));
            event.getGenerator().addProvider(new ModBlockTagsProvider(event.getGenerator(),
                    helper));
        }
    }
}
