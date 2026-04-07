package tfcuwcompat;

import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tfcuwcompat.api.logger.Logger;

@Mod(TFCUWCompat.modID)
public class TFCUWCompat {

    public static final String modID = "tfcuwcompat";
    public static final Logger logger = new Logger(modID);

    public TFCUWCompat() {
        MinecraftForge.EVENT_BUS.register(this);
        logger.info(""); // idk what you put when you
    }

    @SubscribeEvent
    public void onBiomeLoading(BiomeLoadingEvent event) {
        // remove all Untamed Wilds spawns
        for (MobCategory category : MobCategory.values()) {
            event.getSpawns().getSpawnerData(category).removeIf(spawnerData -> {
                if (spawnerData.type != null && spawnerData.type.getRegistryName() != null) {
                    return "untamedwilds".equals(spawnerData.type.getRegistryName().getNamespace());
                }
                return false;
            });
        }
    }
}
