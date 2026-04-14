package tfcuwcompat;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tfcuwcompat.api.logger.Logger;

@Mod(TFCUWCompat.modID)
public class TFCUWCompat {

    public static final String modID = "tfcuwcompat";
    public static final Logger logger = new Logger(modID);

    public TFCUWCompat() {
        MinecraftForge.EVENT_BUS.register(this);
        logger.info("Loading mod ...");
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void blockDefaultUWSpawns(MobSpawnEvent.FinalizeSpawn event) {
        Entity entity = event.getEntity();

        ResourceLocation key = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType());
        if (key == null || !"untamedwilds".equals(key.getNamespace())) {
            return;
        }

        MobSpawnType type = event.getSpawnType();

        if (type == MobSpawnType.NATURAL) {
            event.setSpawnCancelled(true);
        }
    }
}
